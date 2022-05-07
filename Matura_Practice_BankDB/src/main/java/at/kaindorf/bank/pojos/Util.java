package at.kaindorf.bank.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/*
    Created by: Jonas Seidl
    Date: 06.05.2022
    Time: 16:27
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Util {
    @NotBlank(message = "The field must not be empty")
    private String lastname;

    private Long customerId;
}
