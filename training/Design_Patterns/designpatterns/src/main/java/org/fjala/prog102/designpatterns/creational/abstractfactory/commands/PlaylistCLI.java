package org.fjala.prog102.designpatterns.creational.abstractfactory.commands;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playlist.AddPlaylistEntryCLI;
import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playlist.ClearPlaylistCLI;
import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playlist.ShowPlaylistCLI;

import picocli.CommandLine.Command;

@Command(name = "playlist", description = "Manage the Playlist", subcommands = { ClearPlaylistCLI.class,
        AddPlaylistEntryCLI.class, ShowPlaylistCLI.class })
public class PlaylistCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.err.println("Exit code 1: Playlist, subcommand needed");
        return 1;
    }

}
