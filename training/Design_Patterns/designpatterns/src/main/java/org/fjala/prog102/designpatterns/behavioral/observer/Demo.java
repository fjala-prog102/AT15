package org.fjala.prog102.designpatterns.behavioral.observer;

import org.fjala.prog102.designpatterns.behavioral.observer.editor.Editor;
import org.fjala.prog102.designpatterns.behavioral.observer.subscribers.EmailNotificationListener;
import org.fjala.prog102.designpatterns.behavioral.observer.subscribers.LogOpenListener;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}