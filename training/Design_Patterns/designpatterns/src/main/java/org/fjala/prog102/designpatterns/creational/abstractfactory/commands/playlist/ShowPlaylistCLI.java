package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playlist;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;

@Command(name = "show", description = "Shows the Playlist entries")
public class ShowPlaylistCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getPlaylistControl().show();
        return 0;
    }
}
