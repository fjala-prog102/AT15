package org.fjala.prog102.designpatterns.creational.abstractfactory.controls;

public class DefaultEqualizer implements Equalizer {

    @Override
    public void show() {
        System.err.println("Feature not available in the free version!");
    }

    @Override
    public void adjustControls(String equalizerSettings) {
        System.err.println("Feature not available in the free version!");
    }

    @Override
    public void hide() {
        System.err.println("Feature not available in the free version!");
    }

}
