package org.fjala.prog102.designpatterns.creational.abstractfactory.controls;

public class DefaultPlaylist implements Playlist {

    @Override
    public void clear() {
        System.out.println("The Playlist has been cleared");
    }

    @Override
    public void addEntry(String entry) {
        String message = String.format("Adding new entry to the Playlist: %s", entry);
        System.out.println(message);
    }

    @Override
    public void show() {
        System.out.println("Playlist entries:");
        System.out.println(" * movie3.mp4");
        System.out.println("(The free  version only supports a single playlist entry)");
    }
    
}
