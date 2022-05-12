package org.fjala.prog102.designpatterns.behavioral.observer.subscribers;

import java.io.File;

public interface Subscriber {
    void update(String eventType, File file);
}