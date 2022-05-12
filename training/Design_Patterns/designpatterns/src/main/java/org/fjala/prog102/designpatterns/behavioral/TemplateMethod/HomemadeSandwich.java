package org.fjala.prog102.designpatterns.behavioral.TemplateMethod;

public class HomemadeSandwich extends SandwichMaker {
    @Override
    public void prepareSandwich() {
        System.out.println("3. Preparing the homemade sandwich.");
    }
    @Override
    public void addToppings() {
        System.out.println("4. Adding the available sauces and toppings.");
    }
    @Override
    public boolean customerWantsPackedSandwich() {
        return false;
    }
}
