package org.fjala.prog102.designpatterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        Beverage decafWithEverything = new CaramelDecorator(new SoyMilkDecorator(new Decaf()));

        System.out.println(decafWithEverything.description());
        System.out.println(decafWithEverything.cost());
    }
}
