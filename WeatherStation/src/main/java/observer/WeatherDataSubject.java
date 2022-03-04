package observer;

import beans.WeatherData;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:56
*/
public abstract class WeatherDataSubject {
    protected List<WeatherDataObserver> observers = new ArrayList<>();

    public void registerObserver(WeatherDataObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(WeatherDataObserver observer) {
        observers.remove(observer);
    }

    abstract public void notifyObservers(WeatherData wd);

}
