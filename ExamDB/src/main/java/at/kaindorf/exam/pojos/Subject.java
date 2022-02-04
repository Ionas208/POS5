package at.kaindorf.exam.pojos;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", nullable = false)
    private Long id;

    @Column(name = "longname", length = 100)
    private String longname;

    @Column(name = "shortname", length = 10)
    private String shortname;

    @Column(name = "written", nullable = false)
    private Boolean written = false;

    public Boolean getWritten() {
        return written;
    }

    public void setWritten(Boolean written) {
        this.written = written;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}