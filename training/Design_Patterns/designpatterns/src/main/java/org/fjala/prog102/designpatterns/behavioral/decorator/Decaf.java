package org.fjala.prog102.designpatterns.behavioral.decorator;

public class Decaf implements Beverage{
    @Override
    public String description() {
        return "Coffee without caffeine";
    }

    @Override
    public double cost() {
        return 1.00;
    }
}
