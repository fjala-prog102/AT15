package org.fjala.prog102.designpatterns.creational.abstractfactory.commands.equalizer;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;

@Command(name = "hide", description = "Hide Equalizer")
public class HideCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getEqualizerControl().hide();
        return 0;
    }

}
