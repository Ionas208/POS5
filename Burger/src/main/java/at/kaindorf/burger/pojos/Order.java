package at.kaindorf.burger.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 10:27
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private String name;
    private String street;
    private String city;
}
