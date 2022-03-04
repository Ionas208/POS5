package conprod;

import beans.WeatherData;
import observer.WeatherDataObserver;
import observer.WeatherDataSubject;

import java.util.Queue;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:56
*/
public class WeatherDataConsumer extends WeatherDataSubject implements Runnable  {

    private Queue<WeatherData> queue;
    public WeatherDataConsumer(Queue<WeatherData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while (true) {
                synchronized (queue) {
                    if (queue.isEmpty()) {
                        queue.wait();
                    }
                    WeatherData data = queue.poll();
                    notifyObservers(data);
                }
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void notifyObservers(WeatherData wd) {
        for (WeatherDataObserver observer : observers) {
            observer.update(wd);
        }
    }
}
