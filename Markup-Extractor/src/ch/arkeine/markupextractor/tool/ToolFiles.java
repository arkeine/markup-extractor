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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Nils Ryter
 */
public class ToolFiles {

    public static final String URL_FILE_EXTENSION = "urls";
    public static final String COMMAND_FILE_EXTENSION = "cmds";
    public static final String EXTRACTED_FILE_EXTENSION = "csv";
    
    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public static void writeStringToFile(String content, String path,
            String extension) throws IOException {
        File f;
        if (!path.endsWith("." + extension)) {
            f = new File(path + "." + extension);
        } else {
            f = new File(path);
        }
        System.out.println(content);

        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(f))) {
            out.write(content);
        }
    }

    public static String readStringFromFile(String path)
            throws IOException {
        File f = new File(path);
        
        if(!f.exists()) return null;

        try (BufferedReader in = new BufferedReader(
                new FileReader(f))) {
            String line;
            StringBuilder s = new StringBuilder();
            while ((line = in.readLine()) != null) {
                s.append(line);
                s.append("\n");
            }
            
            return s.toString();
        } 
    }

    public static void writeObjectToFile(Object content, String path,
            String extension) throws IOException {
        File f;
        if (!path.endsWith("." + extension)) {
            f = new File(path + "." + extension);
        } else {
            f = new File(path);
        }

        try (ObjectOutput out = new ObjectOutputStream(
                new FileOutputStream(f))) {
            out.writeObject(content);
        } catch (IOException ex) {
            throw ex;
        }
    }

    public static Object readObjectFromFile(String path)
            throws IOException, ClassNotFoundException {
        File f = new File(path);
        
        if(!f.exists()) return null;

        try (ObjectInputStream  in = new ObjectInputStream (
                new FileInputStream(f))) {            
            return in.readObject();
        } catch (IOException ex) {
            throw ex;
        }
    }

    public static FileFilter getUrlsFilter() {
        return new FileFilter() {

            @Override
            public boolean accept(File f) {
                String extension = ToolFiles.getExtension(f);

                return extension != null && extension.equals(
                        URL_FILE_EXTENSION);
            }

            @Override
            public String getDescription() {
                java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(
                        "ch/arkeine/markupextractor/internationalization"); // NOI18N
                return bundle.getString(
                        "FileTool.urls.extensionDescription");
            }
        };
    }

    public static FileFilter getCommandScriptFilter() {
        return new FileFilter() {

            @Override
            public boolean accept(File f) {
                String extension = ToolFiles.getExtension(f);

                return extension != null && extension.equals(
                        COMMAND_FILE_EXTENSION);
            }

            @Override
            public String getDescription() {
                java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(
                        "ch/arkeine/markupextractor/internationalization"); // NOI18N
                return bundle.getString(
                        "FileTool.commandScript.extensionDescription");
            }
        };
    }
}
