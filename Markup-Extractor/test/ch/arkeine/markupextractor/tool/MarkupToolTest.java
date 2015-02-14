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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nils Ryter
 */
public class MarkupToolTest {
   
    //Private method visible like public
    private Method cutDocument;
    private Method searchBeginMarkup;
    private Method searchEndMarkup;

    /**
     * Unlock the visibility restriction to allow testing private methods
     * <p>
     * @throws NoSuchMethodException Error if methods not found
     * @throws ClassNotFoundException Error if class not found
     */
    @Before
    public void setUp() throws NoSuchMethodException, ClassNotFoundException {
        {
            Class params[] = new Class[2];
            params[0] = String.class;
            params[1] = String.class;
            Class myTarget = ToolMarkups.class;
            cutDocument = myTarget.getDeclaredMethod("cutDocument", params);
            cutDocument.setAccessible(true);
        }
        {
            Class params[] = new Class[1];
            params[0] = String[][].class;
            Class myTarget = ToolMarkups.class;
            searchBeginMarkup = myTarget.getDeclaredMethod("searchBeginMarkup",
                    params);
            searchBeginMarkup.setAccessible(true);
        }
        {
            Class params[] = new Class[1];
            params[0] = String[][].class;
            Class myTarget = ToolMarkups.class;
            searchEndMarkup = myTarget.getDeclaredMethod("searchEndMarkup",
                    params);
            searchEndMarkup.setAccessible(true);
        }
    }

    /**
     * Test of cutDocument method, of class MarkupFinder.
     * <p>
     * @throws java.lang.IllegalAccessException Error if private method isn't
     * unlock
     * @throws java.lang.reflect.InvocationTargetException Exception from the
     * called method
     */
    @Test
    public void testCutDocument() throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        System.out.println("cutDocument");
        String key = "TOTO";
        String searchDoc = "TOTOabcTOTOdefTOTOijkTOTOlmn";
        String[][] expResult = {{"", "abc"}, {"abc", "def"}, {"def", "ijk"}, {"ijk", "lmn"}};
        Object[] obj = new Object[2];
        obj[0] = key;
        obj[1] = searchDoc;
        String[][] result = (String[][]) cutDocument.invoke(null, obj);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of searchBeginMarkup method, of class MarkupFinder.
     * <p>
     * @throws java.lang.IllegalAccessException Error if private method isn't
     * unlock
     * @throws java.lang.reflect.InvocationTargetException Exception from the
     * called method
     */
    @Test
    public void testSearchBeginMarkup() throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        System.out.println("searchBeginMarkup");
        String[][] pieces = {{"asdfgh", "qwertz"}, {"gsdfgh", "qwertu"},
        {"asqqdfgh", "qwertwerwe"}};
        String expResult = "dfgh";
        Object obj = pieces;
        String result = (String) searchBeginMarkup.invoke(null, obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchEndMarkup method, of class MarkupFinder.
     * <p>
     * @throws java.lang.IllegalAccessException Error if private method isn't
     * unlock
     * @throws java.lang.reflect.InvocationTargetException Exception from the
     * called method
     */
    @Test
    public void testSearchEndMarkup() throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        System.out.println("searchEndMarkup");
        String[][] pieces = {{"asdfgh", "qwertz"}, {"gsdfgh", "qwertu"},
        {"asqqdfgh", "qwert"}};
        String expResult = "qwert";
        Object obj = pieces;
        String result = (String) searchEndMarkup.invoke(null, obj);
        assertEquals(expResult, result);
    }

}
