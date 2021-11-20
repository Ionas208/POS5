package at.kaindorf.burger.pojos;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Entity
public class Burger implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 2, message = "Must be at least 2 characters")
    private String name;

    @ManyToOne
    @JoinColumn(name="burger_order")
    private Order order;

    @NotNull
    @Size(min = 2, message = "Choose at least 2 ingredients")
    @ManyToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Ingredient> ingredients = new ArrayList<>();


}
