package org.fjala.prog102.designpatterns.creational.builder;

public class Director {
    public void Construct(Builder pConstructor) {
        pConstructor.buildMotor();
        pConstructor.buildCarrocery();
        pConstructor.buildWheel();
    }
}
