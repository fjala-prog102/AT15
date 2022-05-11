package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.audio;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;

@Command(name = "volumeUp", description = "Volume up")
public class VolumeUpCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getAudioSettingsControl().volumeUp();
        return 0;
    }

}
