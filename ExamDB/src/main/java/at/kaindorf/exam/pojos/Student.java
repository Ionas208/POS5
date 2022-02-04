package at.kaindorf.exam.pojos;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long id;

    @Column(name = "firstname", length = 80)
    private String firstname;

    @Column(name = "lastname", length = 80)
    private String lastname;

    @ManyToOne(optional = false)
    @JoinColumn(name = "classname", nullable = false)
    private Classname classname;

    public Classname getClassname() {
        return classname;
    }

    public void setClassname(Classname classname) {
        this.classname = classname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}