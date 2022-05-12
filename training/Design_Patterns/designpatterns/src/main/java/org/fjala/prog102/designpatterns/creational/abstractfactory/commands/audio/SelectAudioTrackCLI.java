package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.audio;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "track", description = "Selects an audio track")
public class SelectAudioTrackCLI implements Callable<Integer> {

    @Parameters(index = "0", description = "The audio track to select", paramLabel = "AUDIO-TRACK")
    private String audioTrack;

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getAudioSettingsControl().selectAudioTrack(audioTrack);
        return 0;
    }

}
