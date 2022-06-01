package ru.rmp.moodnotes.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.rmp.moodnotes.observers.NoteObserver;

public class Note{
    private Date creationDate;
    private String content;

    private List<NoteObserver> observers;

    public void addObservers(NoteObserver observer) {
        observers.add(observer);
    }

    public void removeObservers(NoteObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (NoteObserver o : observers) {
            o.update(message);
        }
    }

    public Note(Date creationDate, String content) {
        observers = new ArrayList();
        this.creationDate = creationDate;
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
