package org.fjala.prog102.designpatterns.creational.abstractfactory.controls.professional;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.DefaultPlaylist;

public class ProfessionalPlaylist extends DefaultPlaylist {
    @Override
    public void show() {
        System.out.println("Playlist entries:");
        System.out.println(" * movie1.mp4");
        System.out.println(" * movie2.mp4");
        System.out.println(" * movie3.mp4");
    }
}
