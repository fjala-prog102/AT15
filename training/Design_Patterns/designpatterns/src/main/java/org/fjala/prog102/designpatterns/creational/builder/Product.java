package org.fjala.prog102.designpatterns.creational.builder;

public class Product {
    private Motor motor;
    private Carrocery carrocery;
    private Wheel wheel;

    public void setMotor(Motor pMotor) {
        motor = pMotor;
        System.out.println("your motor is a : " + motor.specification());
    }

    public void setCarrocery(Carrocery pCarrocery) {
        carrocery = pCarrocery;
        System.out.println("your carrocery is a : " + carrocery.feature());
    }

    public void setWheel(Wheel pWheel) {
        wheel = pWheel;
        System.out.println("your wheels type are: "+ wheel.specif());
    }
    
    public void showCar() {
        System.out.println("Your car has:");
        System.out.println(motor.specification());
        System.out.println(carrocery.feature());
        System.out.println(wheel.specif());
    }
}
