package observer;

import beans.WeatherData;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:57
*/
public class WeatherDataPrinter implements WeatherDataObserver{

    private WeatherDataSubject weatherDataSubject;

    public WeatherDataPrinter(WeatherDataSubject wds) {
        this.weatherDataSubject = wds;
        wds.registerObserver(this);
    }

    @Override
    public void update(WeatherData wd) {
        System.out.println(wd);
    }
}
