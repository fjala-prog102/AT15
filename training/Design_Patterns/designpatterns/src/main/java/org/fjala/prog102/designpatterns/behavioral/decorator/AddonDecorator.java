package org.fjala.prog102.designpatterns.behavioral.decorator;

public abstract class AddonDecorator implements Beverage{
    private Beverage beverage;

    public AddonDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String description(){
        return beverage.description();
    }
    @Override
    public double cost(){
        return beverage.cost();
    }
}
