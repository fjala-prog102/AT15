package org.fjala.prog102.designpatterns.structural.adapter.adaptee;

public class CsvFormatter implements CsvFormattable {

    @Override
    public String formatCsvText(String text) {
        String formattedText=text.replace(".",",");
        return formattedText;
    }

}
