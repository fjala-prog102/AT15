package org.fjala.prog102.designpatterns.behavioral.TemplateMethod;

public class VegSandwich extends SandwichMaker {
    @Override
    public void prepareSandwich() {
        System.out.println("3. Preparing all the salad.");
    }
    @Override
    public void addToppings() {
        System.out.println("4. Adding mozzerella and tomato sauce.");
    }
}
