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
@RequiredArgsConstructor
@Entity
public class Aircraft implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="aircraft_id")
    private int id;


    @NonNull
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="airline_id", referencedColumnName = "airline_id"),
            @JoinColumn(name="airline_name", referencedColumnName = "airline_name")
    })
    private Airline airline;

    @NonNull
    @ManyToOne
    @JoinColumn(name="aircraft_type_id")
    private AircraftType type;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "aircraft")
    private List<Flight> flights = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name="aircraft_airport",
            joinColumns ={@JoinColumn(name="aircraft_id")},
            inverseJoinColumns ={@JoinColumn(name="airport_id")}
    )
    private List<Airport> airports = new ArrayList<>();

    public void addAirport(Airport airport){
        if(!airports.contains(airport)){
            airports.add(airport);
            airport.addAircraft(this);
        }
    }
}
