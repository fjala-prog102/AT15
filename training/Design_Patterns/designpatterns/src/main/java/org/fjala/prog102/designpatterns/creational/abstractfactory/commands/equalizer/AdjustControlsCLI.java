package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.equalizer;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "adjust", description = "Adjust the equalizer controls")
public class AdjustControlsCLI implements Callable<Integer> {

    @Parameters(index = "0", description = "The new equalizer settings to set", paramLabel = "EQUALIZER-SETTINGS")
    private String equalizerSettings;

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getEqualizerControl().adjustControls(equalizerSettings);
        return 0;
    }

}
