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
@IdClass(AirlinePK.class)
public class Airline implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="airline_id")
    private int id;

    @Id
    @Column(name="airline_name", length = 40)
    private String name;

    @OneToMany(mappedBy = "airline")
    private List<Aircraft> aircrafts;

    @OneToMany(mappedBy = "airline", orphanRemoval = true)
    private List<Flight> flights;
}
