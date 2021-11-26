package at.kaindorf.emp.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 26.11.2021
    Time: 10:43
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee{
    @Id
    @GeneratedValue
    @Column(name = "emp_no")
    private Integer employeeNo;

    @Column(name = "firstname", length = 14)
    @NonNull
    @Size(min = 1, max = 14, message = "Firstname must be between 1 and 14 characters")
    private String firstname;

    @Column(name = "lastname", length = 16)
    @NonNull
    @Size(min = 1, max = 16, message = "Lastname must be between 1 and 16 characters")
    private String lastname;

    @Column(name = "gender")
    @NonNull
    private Gender gender;

    @Column(name = "birth_date")
    @NonNull
    private LocalDate dateOfBirth;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dept_no")
    @ToString.Exclude
    private Department department;

    @OneToOne(mappedBy = "deptManager")
    private Department managedDepartment;
}