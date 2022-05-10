package org.fjala.prog102.designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractQuiz implements Cloneable {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private List<QuestionAndAnswer> questions = new ArrayList<>();

    protected AbstractQuiz(String name, String description, List<QuestionAndAnswer> questions) {
        this.name = name;
        this.description = description;
        for (QuestionAndAnswer questionAndAnswer : questions) {
            this.questions.add(new QuestionAndAnswer(questionAndAnswer.getQuestion()));
        }
    }

    protected AbstractQuiz(AbstractQuiz that) {
        this(that.getName(), that.getDescription(), that.getQuestions());
    }

    protected AbstractQuiz() {
    }

    protected abstract AbstractQuiz cloneQuiz() throws CloneNotSupportedException;

    @Override
    public String toString() {
        StringBuilder qaSb = new StringBuilder();
        for (QuestionAndAnswer questionAndAnswer : questions) {
            qaSb.append(questionAndAnswer.toString());
        }
        return String.format("Quiz name: %s\nDescription: %s\nQ&A.\n%s", name, description, qaSb.toString());
    }
}
