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
public class Classname {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="classId")
    private Integer classId;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name="grade")
    private int grade;

    @NonNull
    @Column(name="size")
    private int size;

    @OneToOne(cascade = CascadeType.ALL)
    private Room room;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_teacher")
    private ClassTeacher classTeacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classname)) return false;
        Classname classname = (Classname) o;
        return grade == classname.grade && size == classname.size && Objects.equals(classId, classname.classId) && name.equals(classname.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, name, grade, size);
    }

    @Override
    public String toString() {
        return "Classname{" +
                "classId=" + classId +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", size=" + size +
                '}';
    }
}
