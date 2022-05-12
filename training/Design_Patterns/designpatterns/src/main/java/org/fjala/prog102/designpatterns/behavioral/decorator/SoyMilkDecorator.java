package org.fjala.prog102.designpatterns.behavioral.decorator;

public class SoyMilkDecorator extends AddonDecorator{
    public SoyMilkDecorator(Beverage beverage) {
        super(beverage);
    }
    public String description(){
        return super.description() + " with soy milk";
    }
    public double cost() {
        return super.cost() + 2.00;
    }
}
