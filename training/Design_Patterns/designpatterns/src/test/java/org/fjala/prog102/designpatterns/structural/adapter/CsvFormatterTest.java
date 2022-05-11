package org.fjala.prog102.designpatterns.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fjala.prog102.designpatterns.structural.adapter.adaptee.CsvFormatter;
import org.junit.jupiter.api.Test;

public class CsvFormatterTest {
    @Test
    public void formatCsvTextTest() {
        String newString = " Formatting line 1. Formatting line 2. Formatting line 3.";
        CsvFormatter newCsvFormatter = new CsvFormatter();
        String resultString = newCsvFormatter.formatCsvText(newString);
        String expectedString = " Formatting line 1, Formatting line 2, Formatting line 3,";
        System.out.println(resultString);
        assertEquals(expectedString, resultString);
    }
}
