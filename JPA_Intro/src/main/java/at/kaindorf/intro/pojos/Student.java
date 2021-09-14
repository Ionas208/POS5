package at.kaindorf.intro.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

/*
    Created by: Jonas Seidl
    Date: 14.09.2021
    Time: 09:16
*/
@Data
@AllArgsConstructor
@Entity(name="student")
public class Student {
    @Id
    @Column(name="student_id")
    private String studentId;

    @Column(nullable = false, length = 100)
    private String firstname;

    @Column(nullable = false, length = 150)
    private String lastname;

    @Column(name="date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    public Student() {
        studentId = UUID.randomUUID().toString();
        this.studentId = studentId;
    }
}
