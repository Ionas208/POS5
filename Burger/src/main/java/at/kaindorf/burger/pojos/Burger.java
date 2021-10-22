package at.kaindorf.burger.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 10:26
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Burger implements Serializable {
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();

}
