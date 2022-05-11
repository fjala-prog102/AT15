package org.fjala.prog102.designpatterns.creational.abstractfactory.controls;

public class DefaultSubtitles implements Subtitles {

    @Override
    public void selectLanguage(String language) {
        System.err.println("Feature not available in the free version!");
    }
    
}
