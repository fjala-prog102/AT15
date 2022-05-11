package org.fjala.prog102.designpatterns.creational.abstractfactory.commands;

import java.util.concurrent.Callable;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories.ControlsProvider;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "subtitles", description = "Selects the subtitles language")
public class SubtitlesCLI implements Callable<Integer> {

    @Parameters(index = "0", description = "The subtitles to select", paramLabel = "LANGUAGE")
    private String language;

    @Override
    public Integer call() throws Exception {
        ControlsProvider.getSubtitlesControl().selectLanguage(language);
        return 0;
    }

}
