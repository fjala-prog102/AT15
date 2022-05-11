package org.fjala.prog102.designpatterns.behavioral.observer.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}