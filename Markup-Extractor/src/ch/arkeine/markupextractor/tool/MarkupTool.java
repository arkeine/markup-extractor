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

import java.util.LinkedList;

/**
 *
 * @author Nils Ryter
 */
public class MarkupTool {

    /**
     * Search the maximum length of a markup around a key, between several
     * documents.
     * <p>
     * @param docs Documents where search
     * @param key Text around which search markup
     * @param numOccurrence The occurrence number of the text key wanted (start
     * from 1)
     * @return An array with 2 strings, string at index 0 is the beginning
     * markup and string at the index 1 is the ending markup
     */
    public static String[] searchMarkup(String[] docs, String[] key,
            Integer[] numOccurrence) {
        
        assert docs.length == key.length :  "array must have same length";
        assert docs.length == numOccurrence.length :  "array must have same length";
        
        String[][] pieces = new String[docs.length][2];
        
        for (int i = 0; i < docs.length; ++i) {
            
            assert numOccurrence[i] > 0 : "numOccurrence must be greater than 0";
        
            String[][] temp = cutDocument(key[i], docs[i]);
            pieces[i][0] = temp[numOccurrence[i] - 1][0];
            pieces[i][1] = temp[numOccurrence[i] - 1][1];
        }

        String[] ret = new String[2];
        ret[0] = searchBeginMarkup(pieces);
        ret[1] = searchEndMarkup(pieces);
        return ret;
    }

    /**
     * Cut a document into pieces that can be use by the markup finder.
     * <p>
     * The pieces is the two text which surround the given key, the text before
     * and the text after.<br>
     * For example, if text key is "TOTO" and the document text is
     * "abcTOTOdefTOTOijkTOTOlmn" it will return this array :
     * [abc][def],[def][ijk],[ijk][lmn]
     * <p>
     * @param key Text key to extract
     * @param searchDoc DocumentURL to cut
     * @return Return an array of couple text which surround the key
     */
    private static String[][] cutDocument(String key, String searchDoc) {
        
        assert !key.isEmpty() : "key serched is empty";
        
        //Search the ocurences and get text before and after
        LinkedList<String> lst = new LinkedList();
        StringBuilder txt = new StringBuilder(searchDoc);

        while (txt.indexOf(key) != -1) {
            lst.add(txt.substring(0, txt.indexOf(key)));
            txt.delete(0, txt.indexOf(key) + key.length());
        }

        lst.add(txt.substring(0, txt.length()));

        //Create and fill the array
        String[][] tab = new String[lst.size() - 1][2];

        for (int i = 0; i < tab.length; ++i) {
            tab[i][0] = lst.get(i);
            tab[i][1] = lst.get(i + 1);
        }

        return tab;
    }

    /**
     * Research the best length markup for the pieces given.
     * <p>
     * @param pieces Pieces cut from documents where search markups
     * @return Text of the beginning markup
     */
    private static String searchBeginMarkup(String[][] pieces) {
        int maxLength = searchLengthMarkup(pieces, 0);
        boolean doSearch = true;
        int similarIndex = 0;

        //While the search isn't stop 
        while (doSearch) {
            char tmp = pieces[0][0].charAt(pieces[0][0].length()
                    - similarIndex - 1);
            //Searche for this character in all the pieces
            for (int i = 0; i < pieces.length; ++i) {

                if (pieces[i][0].charAt(pieces[i][0].length()
                        - similarIndex - 1) != tmp) {
                    doSearch = false;
                }
            }

            if (doSearch) {
                ++similarIndex;
            }

            if (similarIndex >= maxLength) {
                doSearch = false;
            }
        }
        return pieces[0][0].substring(pieces[0][0].length()
                - similarIndex, pieces[0][0].length());
    }

    /**
     * Research the best length markup for the pieces given.
     * <p>
     * @param pieces Pieces cut from documents where search markups
     * @return Text of the ending markup
     */
    private static String searchEndMarkup(String[][] pieces) {

        int maxLength = searchLengthMarkup(pieces, 1);
        boolean doSearch = true;
        int similarIndex = 0;

        //While the search isn't stop 
        while (doSearch) {
            char tmp = pieces[0][1].charAt(similarIndex);

            //Searche for this character in all the pieces
            for (int i = 0; i < pieces.length; ++i) {

                if (pieces[i][1].charAt(similarIndex) != tmp) {
                    doSearch = false;
                }
            }

            if (doSearch) {
                ++similarIndex;
            }

            if (similarIndex >= maxLength) {
                doSearch = false;
            }
        }
        return pieces[0][1].substring(0, similarIndex);
    }

    /**
     * Search the maximum length of a markup between pieces.
     * <p>
     * @param pieces Pieces cut from documents where search markups
     * @param pos 0 for the beginning markup length a 1 for the ending
     * @return Maximum length of a markup
     */
    private static int searchLengthMarkup(String[][] pieces, int pos) {
        //Find the maximal length of the searching 
        int maxLength = pieces[0][0].length();

        for (int i = 0; i < pieces.length; ++i) {

            if (maxLength > pieces[i][pos].length()) {
                maxLength = pieces[i][pos].length();
            }
        }
        return maxLength;
    }
}
