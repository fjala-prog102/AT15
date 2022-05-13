package org.fjala.prog102.designpatterns.behavioral.TemplateMethod;

public abstract class SandwichMaker {
    final public void makeSandwich() {  //Template method 
        prepareIngredients();
        toastBread();
        prepareSandwich();
        addToppings();
        heatInMicrowave();
        if (customerWantsPackedSandwich()) {
            packSandwich();
        }
    }
    final void prepareIngredients() {
        System.out.println("1. Preparing sandwiches' essential ingredients: bread, salt, olive oil.");
    }
    final void toastBread() {
        System.out.println("2. Toast the bread for 2 minutes.");
    }

    abstract void prepareSandwich(); //Primitive operation 
    abstract void addToppings(); //Primitive operation 

    final void heatInMicrowave() {
        System.out.println("5. Heat the sandwich in microwave.");
    }
    final void packSandwich() {
        System.out.println("6. Packing sandwich for delivery.");
    }
    boolean customerWantsPackedSandwich() { //Hook operation
        return true;
    }
}