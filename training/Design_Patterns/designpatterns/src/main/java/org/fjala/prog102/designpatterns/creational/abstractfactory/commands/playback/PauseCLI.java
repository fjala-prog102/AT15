package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.playback;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;

@Command(name = "pause", description = "Pause")
public class PauseCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getPlaybackControl().pause();
        return 0;
    }
    
}
