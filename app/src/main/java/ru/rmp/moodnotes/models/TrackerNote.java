package ru.rmp.moodnotes.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.rmp.moodnotes.observers.NoteObserver;

public class TrackerNote {
    private Date creationDate;
    private int scaleValue;
    private String moodValue;

    private List<NoteObserver> observers;

    public void addObserver(NoteObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NoteObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (NoteObserver o : observers) {
            o.update(message);
        }
    }

    public TrackerNote(Date creationDate, int scaleValue, String moodValue) {
        this.creationDate = creationDate;
        this.scaleValue = scaleValue;
        this.moodValue = moodValue;

        observers = new ArrayList<>();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getScaleValue() {
        return scaleValue;
    }

    public void setScaleValue(int scaleValue) {
        this.scaleValue = scaleValue;
    }

    public String getMoodValue() {
        return moodValue;
    }

    public void setMoodValue(String moodValue) {
        this.moodValue = moodValue;
    }
}
