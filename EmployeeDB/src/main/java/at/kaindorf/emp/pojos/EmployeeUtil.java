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
}
