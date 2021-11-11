package at.kaindorf.burger.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.SessionAttributes;

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
public class Burger implements Serializable {
    @NotNull
    @Size(min = 2, message = "Must be at least 2 characters")
    private String name;
    @NotNull
    @Size(min = 2, message = "Choose at least 2 ingredients")
    private List<String> ingredients = new ArrayList<>();

}
