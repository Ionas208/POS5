package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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
public class Aircraft implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="aircraft_id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "airline_name")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name="aircraft_type_id")
    private AircraftType type;

    @OneToMany(mappedBy = "aircraft", orphanRemoval = true)
    private List<Flight> flights;

    @ManyToMany
    @JoinTable(
            name="aircraft_airport",
            joinColumns ={@JoinColumn(name="aircraft_id")},
            inverseJoinColumns ={@JoinColumn(name="airport_id")}
    )
    private List<Airport> airports;
}
