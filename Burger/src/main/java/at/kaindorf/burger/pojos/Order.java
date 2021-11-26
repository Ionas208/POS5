package at.kaindorf.burger.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 10:27
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "burger_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String street;
    @NotBlank
    private String city;

    @OneToMany(mappedBy = "order")
    private List<Burger> burgers = new ArrayList<>();


    public void addBurger(Burger burger){
        burgers.add(burger);
        burger.setOrder(this);
    }
}
