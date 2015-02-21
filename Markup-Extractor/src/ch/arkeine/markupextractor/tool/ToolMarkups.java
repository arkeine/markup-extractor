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
package ch.arkeine.markupextractor.tool;

/**
 *
 * @author Nils Ryter
 */
public class ToolMarkups {

    public static String[] searchMinLenghtMarkup(String[] docs, String[] key,
            Integer[] numOccurrence) throws MarkupToolException {

        String beginMarkup = "";
        String endMarkup = "";
        int[] posDataBegin = new int[docs.length];
        int[] posDataEnd = new int[docs.length];

        for (int i = 0; i < docs.length; i++) {
            posDataEnd[i] = searchOccurenceIndex(docs[i], key[i],
                    numOccurrence[i]);
            posDataBegin[i] = posDataEnd[i] - key[i].length();
            String tempEnd = getMinLengthEndMarkup(docs[i], posDataBegin[i],
                    posDataEnd[i]);
            String tempBegin = getMinLengthBeginMarkup(docs[i], posDataBegin[i]);

            beginMarkup = checkBeginMarkup(docs, posDataBegin, i, tempBegin,
                    beginMarkup);

            endMarkup = checkEndMarkup(docs, posDataBegin, posDataEnd, i,
                    tempEnd, endMarkup);
        }

        String[] ret = new String[2];
        ret[0] = beginMarkup;
        ret[1] = endMarkup;
        return ret;
    }

    //Return endINDEX !!
    public static int searchOccurenceIndex(String content,
            String occurenceTexte, int occurenceNumber) {
        int begin = 0;
        int currentNum = 0;

        while (currentNum < occurenceNumber) {
            begin = content.indexOf(occurenceTexte, begin);

            if (begin == -1) {
                return begin;
            }

            begin += occurenceTexte.length();
            currentNum++;
        }
        return begin;
    }

    private static String getMinLengthBeginMarkup(String doc, int index) {
        String markup = "";
        boolean stop = false;
        int increment = 1;

        while (index - increment >= 0 && !stop) {
            markup = doc.substring(index - increment, index);
            stop = doc.indexOf(markup) + markup.length() == index;
            increment++;
        }

        return markup;
    }

    private static String getMinLengthEndMarkup(String doc, int indexBegin,
            int indexEnd) {
        String markup = "";
        String data = doc.substring(indexBegin, indexEnd);
        boolean stop = false;
        int increment = 1;

        while (indexEnd + increment <= doc.length() && !stop) {
            markup = doc.substring(indexEnd, indexEnd + increment);
            stop = !data.contains(markup);
            increment++;
        }

        return markup;
    }

    private static String checkBeginMarkup(String[] docs, int[] posDataBegin,
            int currentIndex,
            String tempBegin, String beginMarkup) throws MarkupToolException {

        String returnMarkup = beginMarkup;

        if (tempBegin.length() > beginMarkup.length()) {

            if (!tempBegin.endsWith(beginMarkup)) {
                throw new MarkupToolException(
                        "Markup can not be found : the markups "
                        + "don't match");
            }

            //Test of regression for previous documents
            for (int j = currentIndex - 1; j >= 0; j--) {
                if (docs[j].indexOf(tempBegin) + tempBegin.length() != posDataBegin[j]) {
                    throw new MarkupToolException(
                            "Markup can not be found : Regression "
                            + "test fail with document " + j);
                }
            }

            returnMarkup = tempBegin;
        } else {
            int empiriqueIndex = docs[currentIndex].indexOf(beginMarkup) + beginMarkup.length();
            int expectedIndex = posDataBegin[currentIndex];

            if (empiriqueIndex != expectedIndex) {
                throw new MarkupToolException(
                        "Markup can not be found : the markups "
                        + "don't match.\nEmpirique index :" + empiriqueIndex + "\n"
                        + "Expected index : " + expectedIndex);
            }
        }
        return returnMarkup;
    }

    private static String checkEndMarkup(String[] docs, int[] posDataBegin,
            int[] posDataEnd, int currentIndex, String tempEnd, String endMarkup)
            throws MarkupToolException {

        String returnMarkup = endMarkup;

        if (tempEnd.length() > endMarkup.length()) {

            if (!tempEnd.startsWith(endMarkup)) {
                throw new MarkupToolException(
                        "Markup can not be found : the markups "
                        + "don't match");
            }

            //Test of regression for previous documents
            for (int j = currentIndex - 1; j >= 0; j--) {
                if (docs[j].indexOf(tempEnd, posDataBegin[j]) != posDataEnd[j]) {
                    throw new MarkupToolException(
                            "Markup can not be found : Regression "
                            + "test fail with document " + j);
                }
            }

            returnMarkup = tempEnd;
        } else {
            int empiriqueIndex = docs[currentIndex].indexOf(endMarkup,
                    posDataBegin[currentIndex]);
            int expectedIndex = posDataEnd[currentIndex];

            if (empiriqueIndex != expectedIndex && !endMarkup.isEmpty()) {
                throw new MarkupToolException(
                        "Markup can not be found : the markups "
                        + "don't match.\nEmpirique index :" + empiriqueIndex + "\n"
                        + "Expected index : " + expectedIndex);
            }
        }
        return returnMarkup;
    }
}
