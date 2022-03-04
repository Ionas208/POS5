package observer;

import beans.WeatherData;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:56
*/
public interface WeatherDataObserver {
    void update(WeatherData wd);
}
