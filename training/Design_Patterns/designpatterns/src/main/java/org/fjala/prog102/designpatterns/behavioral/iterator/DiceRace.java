package org.fjala.prog102.designpatterns.behavioral.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DiceRace {
    public static Random diceRoll = new Random();
    private static String FINISH_LINE = "Finish Line";

    public static int rollTheDice() {
        return diceRoll.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        // Rules:
        // Two players roll the dice, if they get {1,2,3} they keep their position, if they get {4,5,6} they move one step forward
        // The first one to arrive to the Finish line wins
        // For simplicity, Player One always starts the race

        // The Aggregate: java.util.List<E>
        // The Concrete Aggregate: java.util.ArrayList<E>
        //List<String> track = Arrays.asList("space 1", "space 2", "space 3", "space 4", "space 5", "space 6", "space 7", "space 8", "space 9", FINISH_LINE);
        String[] trackArray = {"space 1", "space 2", "space 3", "space 4", "space 5", "space 6", "space 7", "space 8", "space 9", FINISH_LINE};
        MyList track = new MyList(trackArray);

        // Each Player traverse the aggregate independently, so they need their own Iterator
        // The Iterator: java.util.Iterator<E>
        // The Concrete Iterator: java.util.ArrayList.ListItr
        Iterator<String> playerOnePosition = track.iterator();
        Iterator<String> playerTwoPosition = track.iterator();

        while(true) {
            // Player One throws the dice
            int diceValue = rollTheDice();
            System.out.println("Player One rolled the dice: " + diceValue);
            if (diceValue >= 4) {
                if (playerOnePosition.hasNext()) {
                    String position = playerOnePosition.next();
                    System.out.println("Player One's new position: " + position);
                    if (FINISH_LINE.equals(position)) {
                        System.out.println("Player One has win the game! :-D");
                        break;
                    }
                }
            } else {
                System.out.println("Player One's position remains unchanged! :-(");
            }

            // Player Two throws the dice
            diceValue = rollTheDice();
            System.out.println(" Player Two rolled the dice: " + diceValue);
            if (diceValue >= 4) {
                if (playerTwoPosition.hasNext()) {
                    String position = playerTwoPosition.next();
                    System.out.println(" Player Two's new position: " + position);
                    if (FINISH_LINE.equals(position)) {
                        System.out.println(" Player Two has win the game! :-D");
                        break;
                    }
                }
            } else {
                System.out.println(" Player Two's position remains unchanged! :-(");
            }
        }
    }
}
