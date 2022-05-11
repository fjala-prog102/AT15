package org.fjala.prog102.designpatterns.behavioral.TemplateMethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----Making Veg Sandwich-----");
        SandwichMaker vegSandwich = new VegSandwich();
        vegSandwich.makeSandwich();
        System.out.println();

        System.out.println("-----Making Non Veg Sandwich-----");
        SandwichMaker nonVegSandwich = new NonVegSandwich();
        nonVegSandwich.makeSandwich();
        System.out.println();

        System.out.println("-----Making Homemade Sandwich-----");
        SandwichMaker homemadeSandwich = new HomemadeSandwich();
        homemadeSandwich.makeSandwich();
    }
}
