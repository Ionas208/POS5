package observer;

import beans.WeatherData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:57
*/
public class WeatherDataLogger implements WeatherDataObserver {

    private Path filepath = Paths.get("src/main/resources/log.json");
    private WeatherDataSubject weatherDataSubject;
    private List<WeatherData> weatherData = new ArrayList<>();

    public WeatherDataLogger(WeatherDataSubject wds) {
        this.weatherDataSubject = wds;
        wds.registerObserver(this);
    }

    @Override
    public void update(WeatherData wd) {
        weatherData.add(wd);
        ObjectMapper om = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);;

        try {
            om.writeValue(filepath.toFile(), weatherData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
