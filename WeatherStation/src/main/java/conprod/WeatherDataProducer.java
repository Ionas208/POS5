package conprod;

import beans.WeatherData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:55
*/
public class WeatherDataProducer implements Runnable {

    private Path filepath = Paths.get("src/main/resources/weatherdata.json");
    private Queue<WeatherData> queue;

    private List<WeatherData> readWeatherData() throws IOException {
        ObjectMapper om = new ObjectMapper();
        List<WeatherData> weatherData = new ArrayList<>(Arrays.asList(om.readValue(filepath.toFile(), WeatherData[].class)));
        return weatherData;
    }

    public WeatherDataProducer(Queue<WeatherData>  queue) {
        this.queue = queue;
    }

    private int convertDateTimeToMillis(LocalDateTime ldt) {
        int millis = ldt.getSecond() * 1000 + ldt.getMinute() * 60000 + ldt.getHour() * 3600000;
        return millis;
    }

    @Override
    public void run() {
        try {
            List<WeatherData> weatherData = readWeatherData();
            WeatherData last = null;
            for (WeatherData wd : weatherData) {
                if (last != null) {
                    int timeBetween = convertDateTimeToMillis(wd.getDateTime()) - convertDateTimeToMillis(last.getDateTime());
                    Thread.sleep(timeBetween);
                }
                last = wd;
                synchronized (queue) {
                    queue.add(wd);
                    queue.notify();
                }

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
