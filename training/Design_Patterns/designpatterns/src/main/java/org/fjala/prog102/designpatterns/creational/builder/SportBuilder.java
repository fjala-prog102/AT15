package org.fjala.prog102.designpatterns.creational.builder;

public class SportBuilder implements Builder{
    private Product car = new Product();
    @Override
    public void buildMotor() {
        car.setMotor(new SpecialMotor());
    }

    @Override
    public void buildCarrocery() {
        car.setCarrocery(new SpecialCarrocery());
    }

    @Override
    public void buildWheel() {
        car.setWheel(new SuperWheel());
    }

    public Product getProduct() {
        return car;
    }
}
