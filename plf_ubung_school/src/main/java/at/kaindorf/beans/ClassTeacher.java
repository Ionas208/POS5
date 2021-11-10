package at.kaindorf.beans;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/*
    Created by: Jonas Seidl
    Date: 10.11.2021
    Time: 17:06
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ClassTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="teacherId")
    private Integer teacherId;

    @NonNull
    @Column(name="initials")
    private String initials;

    @NonNull
    @Column(name="firstname")
    private String firstname;

    @NonNull
    @Column(name="lastname")
    private String lastname;

    @NonNull
    @Column(name="title")
    private String title;

    @OneToOne(mappedBy = "classTeacher", cascade = CascadeType.ALL)
    private Classname classname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassTeacher)) return false;
        ClassTeacher that = (ClassTeacher) o;
        return Objects.equals(teacherId, that.teacherId) && initials.equals(that.initials) && firstname.equals(that.firstname) && lastname.equals(that.lastname) && title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, initials, firstname, lastname, title);
    }

    @Override
    public String toString() {
        return "ClassTeacher{" +
                "teacherId=" + teacherId +
                ", initials='" + initials + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
