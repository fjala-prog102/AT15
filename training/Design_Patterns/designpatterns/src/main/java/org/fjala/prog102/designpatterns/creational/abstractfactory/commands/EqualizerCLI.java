package org.fjala.prog102.designpatterns.creational.abstractfactory.commands;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.equalizer.AdjustControlsCLI;
import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.equalizer.HideCLI;
import org.fjala.prog102.designpatterns.creational.abstractfactory.commands.equalizer.ShowCLI;

import picocli.CommandLine.Command;

@Command(name = "equalizer", description = "Access the Equalizer controls", subcommands = { ShowCLI.class,
        AdjustControlsCLI.class, HideCLI.class })
public class EqualizerCLI implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.err.println("Exit code 1: Equalizer, subcommand needed");
        return 1;
    }

}
