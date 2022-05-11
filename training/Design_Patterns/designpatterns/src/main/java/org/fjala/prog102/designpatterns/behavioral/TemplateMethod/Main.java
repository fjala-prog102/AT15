package org.fjala.prog102.designpatterns.behavioral.TemplateMethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----Making Veg Pizza-----");
        PizzaMaker vegPizzaMaker = new VegPizzaMaker();
        vegPizzaMaker.makePizza();
        System.out.println();

        System.out.println("-----Making Non Veg Pizza-----");
        PizzaMaker nonVegPizzaMaker = new NonVegPizzaMaker();
        nonVegPizzaMaker.makePizza();
        System.out.println();

        System.out.println("-----Making In-House Assorted Pizza-----");
        PizzaMaker inHousePizza = new InHouseAssortedPizzaMaker();
        inHousePizza.makePizza();
    }
}
