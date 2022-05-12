package org.fjala.prog102.designpatterns.creational.singleton;

import lombok.Getter;
import lombok.Setter;

public class ConfigurationSingleton {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;





    private static ConfigurationSingleton instance = null;

    public synchronized static ConfigurationSingleton getInstance() {
        if(instance == null) {
            instance = new ConfigurationSingleton();
        }
        return instance;
    }

    private ConfigurationSingleton() {
    }



}
