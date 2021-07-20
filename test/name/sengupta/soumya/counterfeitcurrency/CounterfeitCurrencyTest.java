package name.sengupta.soumya.counterfeitcurrency;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CounterfeitCurrencyTest {

    private void runActualTestWithSingleNote(String serialNumber, int expectedOutcome) {
        List<String> notes = new ArrayList<String>();
        notes.add(serialNumber);

        assertEquals(expectedOutcome, CounterfeitCurrency.countCounterfeit(notes));
    }

    private void runActualTestWithMultipleNotes(List<String> notes, int expectedTotalValue) {
        assertEquals(expectedTotalValue, CounterfeitCurrency.countCounterfeit(notes));
    }

    @Test
    void testWithLessThan10Characters() {
        runActualTestWithSingleNote("Q", 0);
    }

    @Test
    void testWithMoreThan12Characters() {
        runActualTestWithSingleNote("QWE19801000TR", 0);
    }

    @Test
    void testFirst3CharNotAlpha() {
        runActualTestWithSingleNote("QW119801000T", 0);
    }

    @Test
    void testSomeOfFirst3CharNotAlpha() {
        runActualTestWithSingleNote("Q1E19801000T", 0);
    }

    @Test
    void testFirst3CharNotUppercase() {
        runActualTestWithSingleNote("qwe19801000T", 0);
    }

    @Test
    void testSomeOfFirst3CharNotUppercase() {
        runActualTestWithSingleNote("QwE19801000T", 0);
    }

    @Test
    void testNonRepeatingCharInFirst3CharOne() {
        runActualTestWithSingleNote("ABB19991000Z", 0);
    }

    @Test
    void testNonRepeatingCharInFirst3CharTwo() {
        runActualTestWithSingleNote("BBB19991000Z", 0);
    }

    @Test
    void testNext4CharNotDigits() {
        runActualTestWithSingleNote("QWEqwer1000T", 0);
    }

    @Test
    void testSomeOfNext4CharNotDigits() {
        runActualTestWithSingleNote("QWE1q9o1000T", 0);
    }

    @Test
    void testYearPrintedLessThan1900() {
        runActualTestWithSingleNote("QWE189950T", 0);
    }

    @Test
    void testYearPrintedMoreThan2019() {
        runActualTestWithSingleNote("QWE202050T", 0);
    }

    @Test
    void testYearPrinted1900IsValid() {
        runActualTestWithSingleNote("QWE190050T", 50);
    }

    @Test
    void testYearPrinted2019IsValid() {
        runActualTestWithSingleNote("QWE201950T", 50);
    }

    @Test
    void testInvalidDenomination() {
        runActualTestWithSingleNote("QWE198040T", 0);
    }

    @Test
    void testMultipleEndingAlpha() {
        runActualTestWithSingleNote("QWE198050TT", 0);
    }

    @Test
    void testEndingAlphaNotUppercase() {
        runActualTestWithSingleNote("QWE198050t", 0);
    }

    @Test
    void testValidSerialNumber() {
        runActualTestWithSingleNote("QWE198050T", 50);
    }

    @Test
    void testMultipleValidSerialNumbers() {
        List<String> notes = new ArrayList<String>();
        notes.add("QWE1992100E");
        notes.add("JKO20001000F");

        runActualTestWithMultipleNotes(notes, 1100);
    }

    @Test
    void testMultipleInvalidSerialNumbers() {
        List<String> notes = new ArrayList<String>();
        notes.add("QWE192100E");
        notes.add("JKO20001000FF");

        runActualTestWithMultipleNotes(notes, 0);
    }

    @Test
    void testMultipleMixedSerialNumbersOne() {
        List<String> notes = new ArrayList<String>();
        notes.add("QWE1992100E");
        notes.add("JKO20001000F");
        notes.add("QWE192100E");
        notes.add("JKO20001000FF");

        runActualTestWithMultipleNotes(notes, 1100);
    }

    @Test
    void testMultipleMixedSerialNumbersTwo() {
        List<String> notes = new ArrayList<String>();
        notes.add("A201550B");
        notes.add("ABB19991000Z");
        notes.add("XYZ200019Z");
        notes.add("ERF200220");
        notes.add("SCD203010T");

        runActualTestWithMultipleNotes(notes, 0);
    }

    @Test
    void testMultipleMixedSerialNumbersThree() {
        List<String> notes = new ArrayList<String>();
        notes.add("QDB2012R20B");
        notes.add("RED190250E");
        notes.add("RFV201111T");
        notes.add("TYU20121000E");
        notes.add("AAA198710B");
        notes.add("AbC200010E");

        runActualTestWithMultipleNotes(notes, 1050);
    }

}