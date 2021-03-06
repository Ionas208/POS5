package at.kaindorf.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:37
*/
public abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObservers();
}
