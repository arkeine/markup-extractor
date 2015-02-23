/*
 * Copyright 2015 Nils Ryter.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.arkeine.markupextractor.extractor;

import ch.arkeine.markupextractor.UseMarkupExtractor;
import ch.arkeine.markupextractor.tool.ToolUrls;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;

/**
 *
 * @author Nils Ryter
 */
public class Extractor implements Runnable {

    //INPUT
    private final Command[] cmd;
    private final String[] doc;
    private final boolean docIsURL;

    //TOOL
    private boolean isWorkDone;
    private boolean isIncludeBegin;
    private boolean isIncludeEnd;
    private int programCounter;
    private final AbstractMap<Integer, Integer> gotoPassageCounter;

    //OUTPUT
    private final OutputArray extractedData;
    private final List<String> noExtractedDoc;
    private final List<String> extractedDoc;

    public Extractor(Command[] cmd, String[] doc, boolean docIsURL) {
        this.cmd = Arrays.copyOf(cmd, cmd.length);
        this.doc = Arrays.copyOf(doc, doc.length);
        this.docIsURL = docIsURL;

        extractedData = new OutputArray();
        noExtractedDoc = new LinkedList();
        extractedDoc = new LinkedList();
        isIncludeBegin = false;
        isIncludeEnd = false;
        programCounter = 0;
        gotoPassageCounter = new HashMap<>();
    }

    public String[] getDoc() {
        return doc;
    }

    public String[] getExtractedDoc() {
        String[] s = new String[extractedDoc.size()];
        s = extractedDoc.toArray(s);
        return s;
    }

    public String getExtractedToCSV(String separator) {

        if (!separator.isEmpty()) {
            return extractedData.toCSV(separator);
        } else {
            Logger.getLogger(UseMarkupExtractor.class.getName()).log(
                    Level.INFO, "the separator is empty");
            return "";
        }
    }

    public String[][] getExtractedToArray() {
        return extractedData.toArray();
    }

    public String[] getNoExtractedDoc() {
        String[] s = new String[noExtractedDoc.size()];
        s = noExtractedDoc.toArray(s);
        return s;
    }

    public boolean isIsWorkDone() {
        return isWorkDone;
    }

    @Override
    public void run() {

        if (isWorkDone) {
            return;
        }

        double i = 0;
        for (String doc1 : doc) {
            try {
                String extract = docIsURL ? ToolUrls.loadURL(doc1) : doc1;
                extractData(extract);
                extractedData.nextRecord();
                extractedDoc.add(doc1);
            } catch (Exception ex) {
                noExtractedDoc.add(doc1);
                Logger.getLogger(Extractor.class.getName()).log(Level.WARNING,
                        "error while extracting data", ex);
            }
            ++i;
            fireProgressUpdate(i / doc.length * 100);
        }

        isWorkDone = true;
        fireExtractionFinish();
    }

    private void extractData(String d) {
        StringBuilder txtWork = new StringBuilder(d);

        gotoPassageCounter.clear();
        for (programCounter = 0; programCounter < cmd.length; programCounter++) {
            Command cmd1 = cmd[programCounter];

            switch (cmd1.getName()) {
                case COPY:
                    copy(txtWork, cmd1.getParameter1(), cmd1.getParameter2());
                    break;
                case CUT:
                    cut(txtWork, cmd1.getParameter1(), cmd1.getParameter2());
                    break;
                case DELETE:
                    delete(txtWork, cmd1.getParameter1(), cmd1.getParameter2());
                    break;
                case INCLUDE_BEGIN:
                    isIncludeBegin = Boolean.valueOf(cmd1.getParameter1());
                    break;
                case INCLUDE_END:
                    isIncludeEnd = Boolean.valueOf(cmd1.getParameter1());
                    break;
                case RELOAD:
                    txtWork.setLength(0);
                    txtWork.append(d);
                    break;
                case GOTO:
                    goTo(programCounter, cmd1.getParameter1(),
                            cmd1.getParameter2());
                    break;
                default:
                    Logger.getLogger(Extractor.class.getName()).log(
                            Level.SEVERE, "unexpected state");
            }
        }
    }

    private int getBeginIndex(StringBuilder s, String p) {
        if (isIncludeBegin) {
            return s.indexOf(p);
        } else {
            return s.indexOf(p) + p.length();
        }
    }

    private int getEndIndex(StringBuilder s, String p, int fromIndex) {
        if (isIncludeEnd) {
            return s.indexOf(p, fromIndex) + p.length();
        } else {
            return s.indexOf(p, fromIndex);
        }
    }

    private void delete(StringBuilder s, String p1, String p2) {
        int val1 = getBeginIndex(s, p1);
        int val2 = getEndIndex(s, p2, val1);
        val2 = val1 > val2 ? val1 : val2;
        val2 = p2.equals("") ? s.length() : val2;

        if (val1 >= 0) {
            s.delete(val1, val2);
        }

    }

    private void cut(StringBuilder s, String p1, String p2) {
        copy(s, p1, p2);
        delete(s, p1, p2);
    }

    private void copy(StringBuilder s, String p1, String p2) {
        int val1 = getBeginIndex(s, p1);
        int val2 = getEndIndex(s, p2, val1);
        val2 = val1 > val2 ? val1 : val2;
        val2 = p2.equals("") ? s.length() : val2;

        if (val1 >= 0) {
            extractedData.addRecordData(s.substring(val1, val2));
        }
    }

    private void goTo(int gotoNumber, String p1, String p2) {
        try {
            int whereToJump = Integer.valueOf(p1);
            int forNJump = Integer.valueOf(p2);

            int i = gotoPassageCounter.get(gotoNumber) != null
                    ? gotoPassageCounter.get(gotoNumber) : 0;
            if (i < forNJump - 1) {
                gotoPassageCounter.put(gotoNumber, ++i);
                programCounter = whereToJump - 1;
            }
        } catch (NumberFormatException ex) {

        }
    }

    //--------------------------------------------------------------------------
    //  LISTENERS
    //--------------------------------------------------------------------------
    //Liste of listeners
    private transient EventListenerList listeners;

    /**
     * Check if the listeners list is instantiated
     */
    private void instantiatedExtractorListener() {
        if (listeners == null) {
            listeners = new EventListenerList();
        }
    }

    /**
     * Add a listener
     * <p>
     * @param listener Listener
     */
    public void addExtractorListener(ExtractorListener listener) {
        instantiatedExtractorListener();
        listeners.add(ExtractorListener.class, listener);
    }

    /**
     * Remove a listener
     * <p>
     * @param listener Listener
     */
    public void removeExtractorListener(ExtractorListener listener) {
        instantiatedExtractorListener();
        listeners.remove(ExtractorListener.class, listener);
    }

    /**
     * Return the list of the listeners
     * <p>
     * @return List of the listeners
     */
    public ExtractorListener[] getExtractorListener() {
        instantiatedExtractorListener();
        return listeners.getListeners(ExtractorListener.class);
    }

    /**
     * Event fired
     */
    protected void fireProgressUpdate(double percent) {
        instantiatedExtractorListener();
        for (ExtractorListener listener : this.getExtractorListener()) {
            listener.progressUpdate(percent);
        }
    }

    /**
     * Event fired
     */
    protected void fireExtractionFinish() {
        instantiatedExtractorListener();
        for (ExtractorListener listener : this.getExtractorListener()) {
            listener.extractionFinish();
        }
    }
}
