package org.fjala.prog102.designpatterns.creational.abstractfactory.controls.professional;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Subtitles;

public class ProfessionalSubtitles implements Subtitles {

    @Override
    public void selectLanguage(String language) {
        String message = String.format("Subtitles language selected: %s", language);
        System.out.println(message);
    }

}
