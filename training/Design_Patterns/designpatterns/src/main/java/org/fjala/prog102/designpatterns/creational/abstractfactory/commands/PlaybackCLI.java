package org.fjala.prog102.designpatterns.creational.abstractfactory.commands;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playback.PauseCLI;
import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playback.PlayCLI;
import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playback.StopCLI;

import picocli.CommandLine.Command;

@Command(name = "playback", description = "Access the Playback controls", subcommands = { PlayCLI.class, PauseCLI.class,
        StopCLI.class })
public class PlaybackCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.err.println("Exit code 1: Playback, subcommand needed");
        return 1;
    }

}
