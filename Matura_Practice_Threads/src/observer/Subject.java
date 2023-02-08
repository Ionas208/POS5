package observer;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 08:53
*/
public abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObservers();
}
