package at.kaindorf.plf.pojos;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 27.01.2022
    Time: 11:42
*/
@Entity(name = "dept")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Department {
    @Id
    @NonNull
    private Integer deptno;

    @NonNull
    private String dname;

    @NonNull
    private String loc;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Employee> employees;
}
