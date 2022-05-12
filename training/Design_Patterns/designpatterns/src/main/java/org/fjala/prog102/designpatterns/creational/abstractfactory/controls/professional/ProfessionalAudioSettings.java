package org.fjala.prog102.designpatterns.creational.abstractfactory.controls.professional;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.DefaultAudioSettings;

public class ProfessionalAudioSettings extends DefaultAudioSettings {

    @Override
    public void selectAudioTrack(String audioTrack) {
        String message = String.format("Selected audio track: %s", audioTrack);
        System.out.println(message);
    }
}
