package org.fjala.prog102.designpatterns.behavioral.iterator;

import java.util.Iterator;

public class MyListIterator implements Iterator<String> {

    private String[] mystringArray;
    private int position = 0;

    public MyListIterator(String[] array) {
        mystringArray = array;
    }

    @Override
    public boolean hasNext() {
        if (position < mystringArray.length) {
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        String result = mystringArray[position];
        position = position + 1;
        return result;
    }
}
