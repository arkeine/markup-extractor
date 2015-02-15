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
import java.net.URLConnection;

/**
 *
 * @author Nils Ryter
 */
public class ToolUrls {

    /**
     * Load document from an URL.
     * <p>
     * @param url URL to load
     * @return Text extract from the page as a StringBuilder
     * @throws UnsupportedEncodingException URL syntax isn't correct
     * @throws IOException Error when getting the document
     */
    public static String loadURL(String url) throws Exception {
        return loadURL(url, 10000);
    }

    /**
     * Load document from an URL.
     * <p>
     * @param url URL to load
     * @param timeOut
     * @return Text extract from the page as a StringBuilder
     * @throws UnsupportedEncodingException URL syntax isn't correct
     * @throws IOException Error when getting the document
     */
    public static String loadURL(String url, int timeOut) throws Exception {
        //Create URL
        URL site = new URL(url);
        URLConnection connection = site.openConnection();
        connection.setReadTimeout(timeOut);

        //Load the URL
        try (BufferedReader buffer = new BufferedReader(
                new InputStreamReader(site.openStream()))) {
            
            StringBuilder doc = new StringBuilder();
            String inputLine;
            
            //Read through the page and exctract each line
            while ((inputLine = buffer.readLine()) != null) {
                doc.append(inputLine);
                doc.append("\n");
            }
            return doc.toString();
        }
    }

    public static String urlsToString(String[] urls, String separator) {
        StringBuilder s = new StringBuilder();

        for (String url : urls) {
            s.append(url);
            s.append(separator);
        }

        return s.toString();
    }

    public static String[] stringToUrls(String s, String separator) {
        return s.split(separator);
    }
}
