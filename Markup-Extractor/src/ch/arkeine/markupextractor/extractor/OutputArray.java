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

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nils Ryter
 */
public class OutputArray {

    private final ArrayList<ArrayList<String>> records;
    private ArrayList<String> currentRecord;

    public OutputArray() {
        records = new ArrayList<>();
        currentRecord = new ArrayList<>();
        records.add(currentRecord);
    }

    public void nextRecord() {
        currentRecord = new ArrayList<>();
        records.add(currentRecord);
    }

    public void addRecordData(String valeur) {
        if (valeur == null) {
            valeur = "";
            Logger.getLogger(Extractor.class.getName()).log(
                    Level.INFO, "value has been tronqued to empty string");
        }

        currentRecord.add(valeur);
    }

    public String toCSV(String separator) {
        StringBuilder sb = new StringBuilder();

        for (ArrayList<String> al : records) {
            if (!al.isEmpty()) {
                for (String s : al) {
                    sb.append(s);
                    sb.append(separator);
                }
                if (sb.lastIndexOf(separator) != -1) {
                    sb.replace(sb.lastIndexOf(separator), sb.length(), "");
                }
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public String[][] toArray() {
        int max = 0;
        for (ArrayList<String> record : records) {
            max = record.size() > max ? record.size() : max;
        }

        String[][] returnedArray = new String[records.size()][max];

        int i = 0;
        for (ArrayList<String> record : records) {
            int j = 0;
            for (String s : record) {
                returnedArray[i][j] = s;
                j++;
            }
            i++;
        }
        return returnedArray;
    }
}
