package org.fjala.prog102.designpatterns.behavioral.decorator;

public class CaramelDecorator extends AddonDecorator{
    public CaramelDecorator(Beverage beverage) {
        super(beverage);
    }
    public String description(){
        return super.description() + " with caramel";
    }
    public double cost() {
        return super.cost() + 1.00;
    }
}
