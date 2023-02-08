package at.kaindorf.bank.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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
    @NotEmpty
    private String lastname;

    private Long customerId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String option;
}
