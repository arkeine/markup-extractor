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

import ch.arkeine.markupextractor.tool.UrlTool;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nils Ryter
 */
public class Extractor implements Runnable {

    //INPUT
    private final Command[] cmd;
    private final String[] doc;

    //TOOL
    private boolean isWorkDone;

    //OUTPUT
    private final OutputArray extractedData;
    private final List<String> noExtractedDoc;
    private final List<String> extractedDoc;

    public Extractor(Command[] cmd, String[] doc) {
        this.cmd = cmd;
        this.doc = doc;
        extractedData = new OutputArray();
        noExtractedDoc = new LinkedList();
        extractedDoc = new LinkedList();
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
        separator = separator.isEmpty() ? "," : separator;

        return extractedData.toCSV(separator);
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

        for (String doc1 : doc) {
            try {
                String extract = UrlTool.loadURL(doc1, "").toString();
                extractData(extract);
                extractedData.nextRecord();
                extractedDoc.add(doc1);
            } catch (IOException ex) {
                noExtractedDoc.add(doc1);
                Logger.getLogger(Extractor.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }

        isWorkDone = true;
    }

    private void extractData(String d) {
        StringBuilder txtWork = new StringBuilder(d);

        for (Command cmd1 : cmd) {
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
                case RELOAD:
                    txtWork.setLength(0);
                    txtWork.append(d);
                    break;
            }
        }
    }

    private void delete(StringBuilder s, String p1, String p2) {
        int val1 = s.indexOf(p1);
        int val2 = s.indexOf(p2, val1) + p2.length();
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
        int val1 = s.indexOf(p1) + p1.length();
        int val2 = s.indexOf(p2, val1);
        val2 = val1 > val2 ? val1 : val2;
        val2 = p2.equals("") ? s.length() : val2;

        if (val1 >= 0) {
            extractedData.addRecordData(s.substring(val1, val2));
        }
    }
}
