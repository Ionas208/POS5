package pojos;

import lombok.*;

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
@RequiredArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "aircraftsFromAirlineOnAirport", query = "SELECT COUNT(ac) FROM Airport ap join ap.aircrafts ac join ac.airline al " +
                "WHERE ap = :airport AND al = :airline"),
        @NamedQuery(name = "flightsFromAirport", query = "SELECT COUNT(f) FROM Flight f WHERE f.departure_airport = :airport"),
        @NamedQuery(name = "aircraftTypesFromAirline", query = "SELECT COUNT(ac.type.name) FROM Aircraft ac WHERE ac.airline = :airline "),
        @NamedQuery(name = "departureFlightsFromAirlineInTimeSpan", query = "SELECT COUNT(f) FROM Flight f " +
                "WHERE f.departure > :start_date AND f.departure < :end_date AND f.airline = :airline"),
        @NamedQuery(name = "flightsFromAirline", query = "SELECT COUNT(f) FROM Flight f WHERE f.airline = :airline"),
        @NamedQuery(name = "arrivalFlightsFromAirlineInTimeSpan", query = "SELECT COUNT(f) FROM Flight f " +
                "WHERE f.arrival > :start_date AND f.arrival < :end_date AND f.airline = :airline"),
        @NamedQuery(name = "aircraftsFromAirline", query = "SELECT COUNT(ac) FROM Aircraft ac WHERE ac.airline = :airline"),
        @NamedQuery(name = "flightsToAirport", query = "SELECT COUNT(f) FROM Flight f WHERE f.arrival_airport = :airport"),
        @NamedQuery(name = "flightsToCountry", query = "SELECT COUNT(f) FROM Flight f WHERE f.arrival_airport.country = :country"),
        @NamedQuery(name = "flightsFromAircraft", query = "SELECT COUNT(f) FROM Flight f WHERE f.aircraft = :aircraft"),
})
public class Flight implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="flight_id")
    private int id;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="aircraft_id")
    private Aircraft aircraft;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="airline_id", referencedColumnName = "airline_id"),
            @JoinColumn(name="airline_name", referencedColumnName = "airline_name")
    })
    private Airline airline;

    @NonNull
    @Column(name="departure_time")
    private LocalTime departure;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="departure_airport")
    private Airport departure_airport;

    @NonNull
    @Column(name="arrival_time")
    private LocalTime arrival;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="arrival_airport")
    private Airport arrival_airport;
}
