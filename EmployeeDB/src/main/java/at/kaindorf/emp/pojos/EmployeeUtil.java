package at.kaindorf.emp.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 09.12.2021
    Time: 15:25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUtil {
    private List<Integer> toRemove = new ArrayList<>();

    @Size(min = 1, max = 50,message = "Firstname must be at least one character long")
    private String firstname;
    @Size(min = 1, max = 50,message = "Lastname must be at least one character long")
    private String lastname;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate dateOfBirth;
    private String deptNo;
}
