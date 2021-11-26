package at.kaindorf.emp.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 26.11.2021
    Time: 11:57
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dummy {
    private List<Department> departments = new ArrayList<>();
}
