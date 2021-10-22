package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 12:08
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlinePK implements Serializable {
    private int id;
    private String name;
}
