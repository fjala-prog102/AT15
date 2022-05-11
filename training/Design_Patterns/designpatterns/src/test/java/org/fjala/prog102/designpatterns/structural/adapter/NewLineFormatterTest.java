package org.fjala.prog102.designpatterns.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fjala.prog102.designpatterns.structural.adapter.adaptee.CsvFormattable;
import org.fjala.prog102.designpatterns.structural.adapter.adaptee.CsvFormatter;
import org.fjala.prog102.designpatterns.structural.adapter.csvadapter.CsvAdapterImpl;
import org.fjala.prog102.designpatterns.structural.adapter.source.NewLineFormatter;
import org.fjala.prog102.designpatterns.structural.adapter.source.TextFormattable;
import org.junit.jupiter.api.Test;

public class NewLineFormatterTest {
    @Test
    public void formatTextTest() {
        String testString = " Formatting line 1. Formatting line 2. Formatting line 3.";
        TextFormattable newLineFormatter = new NewLineFormatter();
        String resultString = newLineFormatter.formatText(testString);
        System.out.println(resultString);
        String expectedString = " Formatting line 1\n Formatting line 2\n Formatting line 3\n";
        assertEquals(expectedString, resultString);

        CsvFormattable csvFormatter = new CsvFormatter();
        TextFormattable csvAdapter = new CsvAdapterImpl(csvFormatter);
        String resultCsvString = csvAdapter.formatText(testString);
        System.out.println(resultCsvString);
        assertEquals(" Formatting line 1, Formatting line 2, Formatting line 3,", resultCsvString);
    }
}
