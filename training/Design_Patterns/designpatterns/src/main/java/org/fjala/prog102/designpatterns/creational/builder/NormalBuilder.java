package org.fjala.prog102.designpatterns.creational.builder;

public class NormalBuilder implements Builder {
    private Product car = new Product();
    @Override
    public void buildMotor() {
        car.setMotor(new BasicMotor());
    }

    @Override
    public void buildCarrocery() {
        car.setCarrocery(new BasicCarrocery());   
    }

    @Override
    public void buildWheel() {
        car.setWheel(new TwelvWheel());
    }
    public Product getProduct() {
        return car;
    }
}
