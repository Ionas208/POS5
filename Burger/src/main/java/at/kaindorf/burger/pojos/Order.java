package at.kaindorf.burger.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private String name;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
}
