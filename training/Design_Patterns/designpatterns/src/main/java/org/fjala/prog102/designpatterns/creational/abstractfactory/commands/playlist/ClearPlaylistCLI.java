package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playlist;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;

@Command(name = "clear", description = "Clears the Playlist")
public class ClearPlaylistCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getPlaylistControl().clear();
        return 0;
    }

}
