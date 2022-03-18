package beans;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
    Created by: Jonas Seidl
    Date: 04.03.2022
    Time: 11:55
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData implements Comparable<WeatherData> {
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;
    private float temperature;
    private float pressure;
    private float humidity;
    private int windSpeed;
    private int windDirection;

    @Override
    public int compareTo(WeatherData o) {
        return this.dateTime.compareTo(o.dateTime);
    }
}
