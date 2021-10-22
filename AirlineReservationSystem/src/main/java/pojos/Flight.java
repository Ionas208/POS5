package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 11:54
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="flight_id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="aircraft_id")
    private Aircraft aircraft;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airline airline;

    @Column(name="departure_time")
    private LocalTime departure;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="departure_airport")
    private Airport departure_airport;

    @Column(name="arrival_time")
    private LocalTime arrival;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="arrival_airport")
    private Airport arrival_airport;
}
