package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playlist;

import java.io.File;
import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "add", description = "Adds an entry to the Playlist")
public class AddPlaylistEntryCLI implements Callable<Integer> {

    @Parameters(index = "0", description = "The file to add to the playlist", paramLabel = "FILE")
    private File file;

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getPlaylistControl().addEntry(file.toPath().toString());
        return 0;
    }

}
