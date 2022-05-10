package org.fjala.prog102.designpatterns.structural.facade;

public class EmailSenderException extends Exception {

    public EmailSenderException() {
    }

    public EmailSenderException(String message) {
        super(message);
    }

    public EmailSenderException(Throwable cause) {
        super(cause);
    }

    public EmailSenderException(String message, Throwable cause) {
        super(message, cause);
    }

}
