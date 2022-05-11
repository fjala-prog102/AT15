package org.fjala.prog102.designpatterns.creational.abstractfactory.controls;

public class DefaultPlayback implements Playback {

    @Override
    public void play() {
        System.out.println("Playing: movie3.mp4");
    }

    @Override
    public void pause() {
        System.out.println("The Player has been paused");
    }

    @Override
    public void stop() {
        System.out.println("The Player has been stopped");
    }

}
