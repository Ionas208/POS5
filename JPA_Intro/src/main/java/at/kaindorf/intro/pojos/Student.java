package at.kaindorf.intro.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/*
    Created by: Jonas Seidl
    Date: 14.09.2021
    Time: 09:16
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="student")
@IdClass(StudentPK.class)
public class Student implements Serializable {
    @Id
    @NonNull
    private String classname;

    @Id
    @NonNull
    private long catNo;

    @NonNull
    @Column(nullable = false, length = 100)
    private String firstname;

    @NonNull
    @Column(nullable = false, length = 150)
    private String lastname;

    @NonNull
    @Column(name="date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Address address;

    public Student(@NonNull String classname, @NonNull long catNo, @NonNull String firstname, @NonNull String lastname, @NonNull LocalDate dateOfBirth) {
        this.classname = classname;
        this.catNo = catNo;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }
}
