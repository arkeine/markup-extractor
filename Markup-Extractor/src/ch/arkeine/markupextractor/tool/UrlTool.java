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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author Nils Ryter
 */
public class UrlTool {
    
    /**
     * Load document from an URL.
     * <p>
     * @param url URL to load
     * @param parameter Parameter of the URL
     * @return Text extract from the page as a StringBuilder
     * @throws UnsupportedEncodingException URL syntax isn't correct
     * @throws IOException Error when getting the document
     */
    public static StringBuilder loadURL(String url, String parameter) throws
            UnsupportedEncodingException,
            IOException {
        //Create URL
        URL site = new URL(url + URLEncoder.encode(parameter, "UTF-8"));
        StringBuilder doc = new StringBuilder();
        
        //Load the URL
        try(BufferedReader buffer = new BufferedReader(
                    new InputStreamReader(site.openStream()))){
            //Read through the page and exctract each line
            boolean isNextLine = true;
            while (isNextLine) {
                String line = buffer.readLine();
                if (line == null) {
                    isNextLine = false;
                } else {
                    doc.append(line);
                    doc.append("\n");
                }
            }
        } 
        
        return doc;
    }
}
