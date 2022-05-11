package org.fjala.prog102.designpatterns.structural.adapter.csvadapter;

import org.fjala.prog102.designpatterns.structural.adapter.adaptee.CsvFormattable;
import org.fjala.prog102.designpatterns.structural.adapter.source.TextFormattable;

public class CsvAdapterImpl implements TextFormattable {
    CsvFormattable csvFormatter;

    public CsvAdapterImpl(CsvFormattable csvFormatter) {
        this.csvFormatter = csvFormatter;
    }

    @Override
    public String formatText(String text) {
        String formattedText = csvFormatter.formatCsvText(text);
        return formattedText;
    }

}
