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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nils Ryter
 */
public class ToolMarkupsTest {

    @Test
    public void test1() throws Exception {
        System.out.println("searchMinLenghtMarkup");
        String[] docs = {"asdf1N2ghfaert", "aaaxcsdasf1G2gxchfaxert",
            "cxcvb1D2", "1D2aas", "1T2aas"};
        String[] key = {"N", "G", "D", "D", "T"};
        Integer[] numOccurrence = {1, 1, 1, 1, 1};
        String[] expResult = {"1", "2"};
        String[] result = ToolMarkups.searchMinLenghtMarkup(docs, key,
                numOccurrence);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void test2() throws Exception {
        System.out.println("searchMinLenghtMarkup");
        String[] docs = {"aa124N2ff1234N2", "aa1234N2ff124N2", "aa12N2ff1234N2"};
        String[] key = {"N", "N", "N"};
        Integer[] numOccurrence = {2, 1, 2};
        String[] expResult = {"34", "2"};
        String[] result = ToolMarkups.searchMinLenghtMarkup(docs, key,
                numOccurrence);
        assertArrayEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void test3() throws Exception {
        System.out.println("searchMinLenghtMarkup");
        String[] docs = {"aa124N2ff1234N2", "aa1234N2ff124N2", "aa12N2ff123a4N2"};
        String[] key = {"N", "N", "N"};
        Integer[] numOccurrence = {2, 1, 2};
        ToolMarkups.searchMinLenghtMarkup(docs, key, numOccurrence);
    }

    @Test(expected = Exception.class)
    public void test4() throws Exception {
        System.out.println("searchMinLenghtMarkup");
        String[] docs = {"aa124N2ff123a4N2", "aa1234N2ff124N2", "aa12N2ff1234N2"};
        String[] key = {"N", "N", "N"};
        Integer[] numOccurrence = {2, 1, 2};
        ToolMarkups.searchMinLenghtMarkup(docs, key, numOccurrence);
    }

    @Test
    public void test5() throws Exception {
        System.out.println("searchMinLenghtMarkup");
        String[] docs = {"1Totoopac", "1Adooopopac", "1Gastooopaopac"};
        String[] key = {"Toto", "Adooop", "Gastooopa"};
        Integer[] numOccurrence = {1, 1, 1};
        String[] expResult = {"1", "opac"};
        String[] result = ToolMarkups.searchMinLenghtMarkup(docs, key,
                numOccurrence);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void test6() throws Exception {
        System.out.println("searchMinLenghtMarkup");
        String[] docs = {"1Totoopac", "1Adooopopac", "1Tataopac"};
        String[] key = {"Toto", "Adooop", "Tata"};
        Integer[] numOccurrence = {1, 1, 1};
        String[] expResult = {"1", "opa"};
        String[] result = ToolMarkups.searchMinLenghtMarkup(docs, key,
                numOccurrence);
        assertArrayEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void test7() throws Exception {
        System.out.println("searchMinLenghtMarkup");
        String[] docs = {"1Totoopac", "1Adooopopac", "1Tatao"};
        String[] key = {"Toto", "Adooop", "Tata"};
        Integer[] numOccurrence = {1, 1, 1};
        ToolMarkups.searchMinLenghtMarkup(docs, key,
                numOccurrence);
    }

    @Test(expected = Exception.class)
    public void test8() throws Exception {
        System.out.println("searchMinLenghtMarkup");
        String[] docs = {"1Totoopa", "1Adooopopac", "1Gastooopaopac"};
        String[] key = {"Toto", "Adooop", "Gastooopa"};
        Integer[] numOccurrence = {1, 1, 1};
        ToolMarkups.searchMinLenghtMarkup(docs, key,
                numOccurrence);
    }

    @Test
    public void testSearchOccurenceIndex() {
        System.out.println("searchOccurenceIndex");
        String content = "trololo123asdasdg123jhlkjl123";
        String occurenceTexte = "123";
        int occurenceNumber = 2;
        int expResult = 20;
        int result = ToolMarkups.searchOccurenceIndex(content, occurenceTexte,
                occurenceNumber);
        assertEquals(expResult, result);
    }

}
