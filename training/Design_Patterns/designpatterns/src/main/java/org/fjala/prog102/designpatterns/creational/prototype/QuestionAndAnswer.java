package org.fjala.prog102.designpatterns.creational.prototype;

import lombok.Getter;
import lombok.Setter;

public class QuestionAndAnswer implements Cloneable {

    @Getter
    @Setter
    private String question;

    @Getter
    @Setter
    private String answer;

    public QuestionAndAnswer(String question) {
        this.question = question;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("Q: %s\nA: %s\n", question, answer);
    }
}
