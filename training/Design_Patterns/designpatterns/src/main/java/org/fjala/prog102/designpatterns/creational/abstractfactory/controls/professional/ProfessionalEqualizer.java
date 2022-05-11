package org.fjala.prog102.designpatterns.creational.abstractfactory.controls.professional;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Equalizer;

public class ProfessionalEqualizer implements Equalizer {

    @Override
    public void show() {
        System.out.println("Show equalizer");
    }

    @Override
    public void adjustControls(String equalizerSettings) {
        String message = String.format("New equalizer adjustments to set: %s", equalizerSettings);
        System.out.println(message);
    }

    @Override
    public void hide() {
        System.out.println("Hide equalizer");
    }
    
}
