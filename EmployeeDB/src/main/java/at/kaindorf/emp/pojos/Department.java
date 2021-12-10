package at.kaindorf.emp.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 26.11.2021
    Time: 10:44
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Department {
    @Id
    @Column(name = "dept_no", length = 4)
    @JsonProperty("number")
    private String deptNo;

    @Column(name = "dept_name", length = 40)
    @NonNull
    @Size(min = 1, max = 40, message = "Department name must be between 1 and 40 characters")
    @JsonProperty("name")
    private String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonProperty("employees")
    private List<Employee> employees = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_no")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonProperty("deptManager")
    private Employee deptManager;

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setDepartment(this);
    }

    public void setDeptManager(Employee employee) {
        this.deptManager = employee;
        employee.setManagedDepartment(this);
    }
}
