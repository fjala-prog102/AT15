package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.audio;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;

@Command(name = "mute", description = "Mute audio")
public class MuteCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getAudioSettingsControl().mute();
        return 0;
    }

}
