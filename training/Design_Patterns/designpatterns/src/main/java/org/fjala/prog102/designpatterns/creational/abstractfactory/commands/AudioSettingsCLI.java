package org.fjala.prog102.designpatterns.creational.abstractfactory.commands;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.audio.MuteCLI;
import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.audio.SelectAudioTrackCLI;
import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.audio.VolumeDownCLI;
import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.audio.VolumeUpCLI;

import picocli.CommandLine.Command;

@Command(name = "audio", description = "Manage the audio settings", subcommands = { SelectAudioTrackCLI.class,
        VolumeUpCLI.class, VolumeDownCLI.class, MuteCLI.class })
public class AudioSettingsCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.err.println("Exit code 1: Audio Settings, subcommand needed");
        return 1;
    }

}
