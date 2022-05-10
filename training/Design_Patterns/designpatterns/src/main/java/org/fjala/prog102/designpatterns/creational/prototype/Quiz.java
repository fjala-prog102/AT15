package org.fjala.prog102.designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends AbstractQuiz {

    public Quiz(String name, String description, List<QuestionAndAnswer> questions) {
        super(name, description, questions);
    }

    public Quiz(AbstractQuiz that) {
        super(that);
    }

    public Quiz() {
        super();
    }

    @Override
    protected AbstractQuiz cloneQuiz() throws CloneNotSupportedException {
        Quiz quiz = (Quiz) super.clone();

        List<QuestionAndAnswer> questions = new ArrayList<>();

        for (QuestionAndAnswer questionAndAnswer : quiz.getQuestions()) {
            questions.add((QuestionAndAnswer) questionAndAnswer.clone());
        }

        quiz.setQuestions(questions);
        return quiz;
    }
}
