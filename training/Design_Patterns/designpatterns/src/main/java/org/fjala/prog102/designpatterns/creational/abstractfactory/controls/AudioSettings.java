package org.fjala.prog102.designpatterns.creational.abstractfactory.controls;

public interface AudioSettings {
    void selectAudioTrack(String audioTrack);

    void volumeUp();

    void volumeDown();

    void mute();
}
