package org.fjala.prog102.designpatterns.creational.abstractfactory.controls;

public class DefaultAudioSettings implements AudioSettings {

    @Override
    public void selectAudioTrack(String audioTrack) {
        System.err.println("Feature not available in the free version!");
    }

    @Override
    public void volumeUp() {
        System.out.println("Volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("Volume down");
    }

    @Override
    public void mute() {
        System.out.println("The audio has been muted");
    }
    
}
