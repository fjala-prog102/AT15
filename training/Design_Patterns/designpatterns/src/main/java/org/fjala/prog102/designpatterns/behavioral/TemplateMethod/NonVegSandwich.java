package org.fjala.prog102.designpatterns.behavioral.TemplateMethod;

public class NonVegSandwich extends SandwichMaker {
    @Override
    public void prepareSandwich() {
        System.out.println("3. Preparing chicken ham, and smoked meat.");
    }
    @Override
    public void addToppings() {
        System.out.println("4. Adding cheese and BBQ sauce.");
    }
}
