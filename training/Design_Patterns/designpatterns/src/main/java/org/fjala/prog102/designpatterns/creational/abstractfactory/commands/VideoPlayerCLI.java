package org.fjala.prog102.designpatterns.creational.abstractfactory.commands;

import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "vplayer", mixinStandardHelpOptions = true, version = "vplayer 1.0.0", description = "Video Player CLI", subcommands = {
        PlaylistCLI.class, PlaybackCLI.class, EqualizerCLI.class, AudioSettingsCLI.class, SubtitlesCLI.class })
public class VideoPlayerCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Exit code 1: Subcommand needed");
        return 1;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new VideoPlayerCLI()).execute(args);
        System.exit(exitCode);
    }
}
