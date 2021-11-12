package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 11:54
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AircraftType implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="aircraft_type_id")
    private int id;

    @Column(name="type_name", length = 50)
    private String name;

    @Column(name="seats")
    private int seats;
}
