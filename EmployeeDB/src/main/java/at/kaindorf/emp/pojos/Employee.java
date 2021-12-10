package at.kaindorf.emp.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
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
    @Column(name = "emp_no")
    @JsonProperty("emp_no")
    private Integer employeeNo;

    @Column(name = "firstname", length = 14)
    @NonNull
    @Size(min = 1, max = 14, message = "Firstname must be between 1 and 14 characters")
    @NotBlank(message = "Firstname must not be empty")
    @JsonProperty("firstname")
    private String firstname;

    @Column(name = "lastname", length = 16)
    @NonNull
    @Size(min = 1, max = 16, message = "Lastname must be between 1 and 16 characters")
    @NotBlank(message = "Lastname must not be empty")
    @JsonProperty("lastname")
    private String lastname;

    @Column(name = "gender")
    @NonNull
    @JsonProperty("gender")
    private Gender gender;

    @Column(name = "birth_date")
    @NonNull
    @JsonProperty("birthDate")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dept_no")
    @ToString.Exclude
    @JsonIgnore
    private Department department;

    @OneToOne(mappedBy = "deptManager")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Department managedDepartment;
}