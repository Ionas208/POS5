package at.kaindorf.pattern.observer;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:37
*/
public class ConcreteSubject extends Subject {

    private String data;

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(data);
        }
    }
}
