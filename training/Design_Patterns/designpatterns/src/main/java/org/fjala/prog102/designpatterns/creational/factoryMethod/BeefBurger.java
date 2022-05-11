package org.fjala.prog102.designpatterns.creational.factoryMethod;

public class BeefBurger implements Burger {

    @Override
    public void prepare() {
        // Prepare Beef Burger
        System.out.println("Preparing Beef Burger...");
    }
}