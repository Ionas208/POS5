package observer;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 08:54
*/
public class ConcreteObserver implements Observer{

    private Subject subject;

    public ConcreteObserver(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String data) {
        System.out.println(data);
    }
}
