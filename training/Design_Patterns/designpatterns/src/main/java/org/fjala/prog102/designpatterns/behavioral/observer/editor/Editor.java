package org.fjala.prog102.designpatterns.behavioral.observer.editor;

import java.io.File;

import org.fjala.prog102.designpatterns.behavioral.observer.publisher.PublisherManager;

public class Editor {
    public PublisherManager events;
    private File file;

    public Editor() {
        this.events = new PublisherManager("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}