package org.fjala.prog102.designpatterns.behavioral.observer.publisher;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fjala.prog102.designpatterns.behavioral.observer.subscribers.Subscriber;

public class PublisherManager {
    Map<String, List<Subscriber>> listeners = new HashMap<>();

    public PublisherManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, Subscriber listener) {
        List<Subscriber> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, Subscriber listener) {
        List<Subscriber> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file) {
        List<Subscriber> users = listeners.get(eventType);
        for (Subscriber listener : users) {
            listener.update(eventType, file);
        }
    }
}