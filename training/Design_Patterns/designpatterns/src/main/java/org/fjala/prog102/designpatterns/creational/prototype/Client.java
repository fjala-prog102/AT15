package org.fjala.prog102.designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {

        // Prototypes registry
        Map<String, AbstractQuiz> prototypes = new HashMap<>();

        // Build prototype
        AbstractQuiz quiz1 = new Quiz();
        quiz1.setName("Demo quiz #1");
        quiz1.setDescription("Demo quiz #1 description");
        quiz1.getQuestions().add(new QuestionAndAnswer("When's your birthday?"));
        quiz1.getQuestions().add(new QuestionAndAnswer("What's your favorite color?"));
        quiz1.getQuestions().add(new QuestionAndAnswer("What's your favorite dish?"));

        // Store prototype
        prototypes.put("q1", quiz1);


        // Build another prototype
        AbstractQuiz quiz2 = new Quiz();
        quiz2.setName("Pet quiz #2");
        quiz2.setDescription("Pet quiz #2 description");
        quiz2.getQuestions().add(new QuestionAndAnswer("Your pet name?"));
        quiz2.getQuestions().add(new QuestionAndAnswer("Your pet color?"));
        quiz2.getQuestions().add(new QuestionAndAnswer("Your pet favorite dish?"));
        quiz2.getQuestions().add(new QuestionAndAnswer("Your pet nickname?"));
        quiz2.getQuestions().add(new QuestionAndAnswer("Your pet favorite game?"));

        // Store prototype
        prototypes.put("q2", quiz2);

        // Retrieve and build based on prototype 'q1'
        // Two implementation methods
        // 1) Copy constructor
        //AbstractQuiz clonedQuiz1 = new Quiz(prototypes.get("q1"));
        // 2) implements Cloneable and uses clone()
        AbstractQuiz clonedQuiz1 = prototypes.get("q1").cloneQuiz();
        clonedQuiz1.getQuestions().get(0).setAnswer("1970-01-01");
        clonedQuiz1.getQuestions().get(1).setAnswer("Blue");
        clonedQuiz1.getQuestions().get(2).setAnswer("Hamburguer");

        System.out.println("Cloned Quiz:\n\n" + clonedQuiz1);
        System.out.println("");
        System.out.println("Prototype Quiz:\n\n" + quiz1);


        // Retrieve and build based on prototype 'q2'
        // Two implementation methods
        // 1) Copy constructor
        //AbstractQuiz clonedQuiz2 = new Quiz(prototypes.get("q2"));
        // 2) implements Cloneable and uses clone()
        AbstractQuiz clonedQuiz2 = prototypes.get("q2").cloneQuiz();
        clonedQuiz2.getQuestions().add(new QuestionAndAnswer("Your pet favorite friend?"));
        clonedQuiz2.getQuestions().get(0).setAnswer("Garfield");
        clonedQuiz2.getQuestions().get(1).setAnswer("Orange");
        clonedQuiz2.getQuestions().get(2).setAnswer("Lasagne");
        clonedQuiz2.getQuestions().get(3).setAnswer("Garfield");
        clonedQuiz2.getQuestions().get(4).setAnswer("Scare Oddie");
        clonedQuiz2.getQuestions().get(5).setAnswer("Me");

        System.out.println("Cloned Quiz:\n\n" + clonedQuiz2);
        System.out.println("");
        System.out.println("Prototype Quiz:\n\n" + quiz2);
    }
}
