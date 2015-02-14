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

import ch.arkeine.markupextractor.tool.ToolFiles;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nils Ryter
 */
public class ExtractorTest {
    
    private String doc;
    
    public ExtractorTest() {
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(
                "ch/arkeine/markupextractor/textTest"); // NOI18N
        
        File temp = new File("textTest.txt");
        
        try {
            System.out.println("ici : "+ToolFiles.readStringFromFile(temp.getAbsolutePath()));
            
//        String expResult = "Ceci est un fichier de test dont le contenu"
//                + " est totalement arbitraire\n";
//        String result = instance.getOriginalDoc();
//        assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(ExtractorTest.class.getName()).log(Level.SEVERE,
                    null, ex);
            
        }
    }
    

    @Test
    public void test1() {
        System.out.println("test1");
        String separator = ",";
        
        Command[] cmd = new Command[1];
        String[] doc = new String[1];
        
        cmd[0] = new Command(Command.CommandName.COPY);
        cmd[0].setParameter1("<test>");
        cmd[0].setParameter2("</t>");
        doc[0] = "<test>d</t>";
        
        Extractor instance = new Extractor(cmd, doc);
        instance.run();
        
        String expResult = "d";
        String result = instance.getExtractedToCSV(separator).trim();
        assertEquals(expResult, result);
    }   
    
    @Test
    public void test2() {
        System.out.println("test2");
        String separator = ",";
        
        Command[] cmd = new Command[1];
        String[] doc = new String[1];
        
        cmd[0] = new Command(Command.CommandName.COPY);
        cmd[0].setParameter1("</t>");
        cmd[0].setParameter2("<t>");
        doc[0] = "</t>d<t>";
        
        Extractor instance = new Extractor(cmd, doc);
        instance.run();
        
        String expResult = "d";
        String result = instance.getExtractedToCSV(separator).trim();
        assertEquals(expResult, result);
    }   
    
    @Test
    public void test3() {
        System.out.println("test3");
        String separator = ",";
        
        Command[] cmd = new Command[3];
        String[] doc = new String[1];
        
        cmd[0] = new Command(Command.CommandName.DELETE);
        cmd[0].setParameter1("nom");
        cmd[0].setParameter2(" ");
        cmd[1] = new Command(Command.CommandName.CUT);
        cmd[1].setParameter1("nom:");
        cmd[1].setParameter2(" ");
        cmd[2] = new Command(Command.CommandName.COPY);
        cmd[2].setParameter1(":");
        cmd[2].setParameter2("");
        doc[0] = "nom:toto nom:marie nom:joel";
        
        Extractor instance = new Extractor(cmd, doc);
        instance.run();
        
        String expResult = "marie" + separator +"joel";
        String result = instance.getExtractedToCSV(separator).trim();
        assertEquals(expResult, result);
    }    
}
