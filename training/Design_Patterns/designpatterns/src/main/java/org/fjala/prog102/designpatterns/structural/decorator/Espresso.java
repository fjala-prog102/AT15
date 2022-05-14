package org.fjala.prog102.designpatterns.structural.decorator;

public class Espresso implements Beverage{
    @Override
    public String description() {
        return "Espresso Coffee";
    }

    @Override
    public double cost() {
        return 2.00;
    }
}
