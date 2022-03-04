package at.kaindorf.pattern.observer;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:37
*/
public class ConcreteObserver implements Observer {
    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void update(String data) {
        System.out.println(data);
    }
}
