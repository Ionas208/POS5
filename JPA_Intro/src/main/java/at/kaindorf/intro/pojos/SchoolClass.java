package at.kaindorf.intro.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 21.09.2021
    Time: 08:20
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name="school_class")
public class SchoolClass implements Serializable {
    @Id
    @Column(length = 10, name="classname")
    @NonNull
    private String className;

    @OneToMany(mappedBy = "className", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s){
        if(!students.contains(s)){
            students.add(s);
            s.setClassName(this);
        }
    }
}
