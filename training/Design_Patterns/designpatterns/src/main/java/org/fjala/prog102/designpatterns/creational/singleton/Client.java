package org.fjala.prog102.designpatterns.creational.singleton;

public class Client {
    public static void main(String[] args) {
        // Create and initialize the Singleton
        ConfigurationSingleton singleton1 = ConfigurationSingleton.getInstance();
        singleton1.setName("A configuration entry");
        singleton1.setDescription("Some description");

        // Later I can access the Singleton
        ConfigurationSingleton singleton2 = ConfigurationSingleton.getInstance();
        singleton2.setName("A modified configuration entry");
        singleton2.setDescription("Some modified description");

        if (singleton1 == singleton2) {
            System.out.println("Instances are the same");
            if (singleton1.getName().equals("A modified configuration entry") &&
                    singleton1.getDescription().equals("Some modified description")) {
                System.out.println("Instances are the same x2");
            }
        }
    }
}
