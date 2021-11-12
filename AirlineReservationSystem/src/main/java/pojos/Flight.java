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
@NamedQueries({
        @NamedQuery(name = "aircraftsFromAirlineOnAirport", query = "SELECT COUNT(ac) FROM Airport ap join ap.aircrafts ac join ac.airline al " +
                "WHERE ap.name = :airport AND al.name = :airline"),
        @NamedQuery(name = "flightsFromAirport", query = "SELECT COUNT(f) FROM Flight f WHERE f.departure_airport.name = :airport"),
        @NamedQuery(name = "aircraftTypesFromAirline", query = "SELECT COUNT(ac.type.name) FROM Aircraft ac WHERE ac.airline.name = :airline GROUP BY ac.type.name "),
        @NamedQuery(name = "departureFlightsFromAirlineInTimeSpan", query = "SELECT f FROM Flight f " +
                "WHERE f.departure > :start_date AND f.departure < :end_date AND f.airline.name = :airline"),
        @NamedQuery(name = "flightsFromAirport", query = "SELECT COUNT(f) FROM Flight f GROUP BY f.departure_airport.name"),
        @NamedQuery(name = "flightsFromAirline", query = "SELECT COUNT(f) FROM Flight f GROUP BY f.airline.name"),
        @NamedQuery(name = "arrivalFlightsFromAirlineInTimeSpan", query = "SELECT f FROM Flight f " +
                "WHERE f.arrival > :start_date AND f.arrival < :end_date AND f.airline.name = :airline"),
        @NamedQuery(name = "mostFlightsToCountry", query = "SELECT f.arrival_airport.country, COUNT(f) FROM Flight f GROUP BY f.arrival_airport.country"),
        @NamedQuery(name = "mostFlightsFromCountry", query = "SELECT f.arrival_airport.country, COUNT(f) FROM Flight f GROUP BY f.departure_airport.country"),
        @NamedQuery(name = "mostFlightsToCity", query = "SELECT MAX(COUNT(f)) FROM Flight f GROUP BY f.arrival_airport.city"),
})
public class Flight implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="flight_id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="aircraft_id")
    private Aircraft aircraft;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="airline_name")
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
