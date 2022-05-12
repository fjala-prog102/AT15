package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.audio;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;

@Command(name = "volumeDown", description = "Volume down")
public class VolumeDownCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getAudioSettingsControl().volumeDown();
        return 0;
    }

}
