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
    private static final int NAME_LEN = 50;

    @Id
    @GeneratedValue
    @Column(name="aircraft_type_id")
    private int id;

    @Column(name="type_name", length = NAME_LEN)
    private String name;

    @Column(name="seats")
    private int seats;

    public AircraftType(String line){
        String[] parts = line.split(",");
        String name = parts[1].trim();
        this.name = name.length() > NAME_LEN ? name.substring(0, NAME_LEN) : name;
        this.seats = Integer.parseInt(parts[8]);
    }
}
