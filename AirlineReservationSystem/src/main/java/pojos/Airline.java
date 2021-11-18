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
@IdClass(AirlinePK.class)
public class Airline implements Serializable {

    private static final int NAME_LEN = 40;

    @Id
    @GeneratedValue
    @Column(name="airline_id")
    private int id;

    @Id
    @Column(name="airline_name", length = NAME_LEN)
    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "airline")
    private List<Aircraft> aircrafts = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "airline")
    private List<Flight> flights = new ArrayList<>();

    public Airline(String line){
        String[] parts = line.split(",");
        String name = parts[1].trim();
        this.name = name.length() > NAME_LEN ? name.substring(0, NAME_LEN) : name;
    }

    public void addAircraft(Aircraft aircraft){
        if(!aircrafts.contains(aircraft)){
            aircrafts.add(aircraft);
        }
    }

    public void addFlight(Flight flight){
        if(!flights.contains(flight)){
            flights.add(flight);
        }
    }
}
