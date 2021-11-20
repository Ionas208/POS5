package at.kaindorf.burger.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 10:27
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient implements Serializable {
    @Id
    private String id;

    private String name;
    private Type type;


    public static enum Type{
        PATTY, VEGGIE, CHEESE
    }
}
