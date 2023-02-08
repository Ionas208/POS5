package observer;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 08.05.2022
    Time: 08:54
*/
public class ConcreteSubject extends Subject{

    private String data;

    @Override
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(data);
        }
    }
}
