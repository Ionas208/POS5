package at.kaindorf.plf.pojos;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 27.01.2022
    Time: 11:42
*/
@Entity(name = "emp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private Integer empno;

    @NotNull(message = "Name is required")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String ename;

    @NotNull(message = "Job is required")
    @Size(min = 1, max = 255, message = "Job must be between 1 and 255 characters")
    private String job;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Hire date is required")
    private LocalDate hiredate;

    @NotNull(message = "Salary is required")
    @Range(min = 0, max = 9999, message = "Salary must be between 0 and 9999")
    private Integer sal;

    private Integer comm;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deptno")
    private Department dept;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mgr")
    private Employee manager;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Employee> managedEmployees;
}
