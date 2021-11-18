package pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 11:54
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airport implements Serializable {

    private final static int NAME_LEN = 60;
    private final static int COUNTRY_LEN = 60;
    private final static int CITY_LEN = 60;

    @Id
    @GeneratedValue
    @Column(name="airport_id")
    private int id;

    @Column(name="name", length = NAME_LEN)
    private String name;

    @Column(name="country", length = COUNTRY_LEN)
    private String country;

    @Column(name="city", length = CITY_LEN)
    private String city;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "airports")
    private List<Aircraft> aircrafts = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "departure_airport")
    private List<Flight> departure_flights = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "arrival_airport")
    private List<Flight> arrival_flights = new ArrayList<>();

    public Airport(String line){
        String[] parts = line.split(",");

        String name = parts[3].trim();
        this.name = name.length() > NAME_LEN ? name.substring(0, NAME_LEN) : name;

        String country = parts[8].trim();
        this.country = country.length() > COUNTRY_LEN ? country.substring(0, COUNTRY_LEN) : country;

        String city = parts[10].trim();
        this.city = city.length() > CITY_LEN ? city.substring(0, CITY_LEN) : city;
    }

    public void addAircraft(Aircraft aircraft){
        if(!aircrafts.contains(aircraft)){
            aircrafts.add(aircraft);
        }
    }

    public void addDepartureFlight(Flight f){
        if(!departure_flights.contains(f)){
            departure_flights.add(f);
        }
    }

    public void addArrivalFlight(Flight f){
        if(!arrival_flights.contains(f)){
            arrival_flights.add(f);
        }
    }
}
