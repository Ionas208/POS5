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
public class Airport implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="airport_id")
    private int id;

    @Column(name="name", length = 60)
    private String name;

    @Column(name="country", length = 60)
    private String country;

    @Column(name="city", length = 50)
    private String city;

    @ManyToMany(mappedBy = "airports")
    private List<Aircraft> aircrafts;

    @OneToMany(mappedBy = "departure_airport", orphanRemoval = true)
    private List<Flight> departure_flights;

    @OneToMany(mappedBy = "arrival_airport", orphanRemoval = true)
    private List<Flight> arrival_flights;
}
