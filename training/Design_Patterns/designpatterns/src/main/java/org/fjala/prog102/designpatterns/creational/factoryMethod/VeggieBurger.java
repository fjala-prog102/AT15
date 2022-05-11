package org.fjala.prog102.designpatterns.creational.factoryMethod;

public class VeggieBurger implements Burger {

    @Override
    public void prepare() {
        // Prepare Veggie Burger
        System.out.println("Preparing Veggie Burger...");
    }

}