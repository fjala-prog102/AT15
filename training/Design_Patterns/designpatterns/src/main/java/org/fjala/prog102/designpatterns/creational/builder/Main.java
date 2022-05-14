package org.fjala.prog102.designpatterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        NormalBuilder normal = new NormalBuilder();
        director.Construct(normal);
        normal.getProduct();

        System.out.println("-------------------------");
        //Building a sport car
        SportBuilder sport = new SportBuilder();
        director.Construct(sport);
        sport.getProduct();

    }
}