package at.kaindorf.exam.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exam")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id", nullable = false)
    private Long id;

    @Column(name = "dateofexam")
    @NonNull
    private LocalDate dateofexam;

    @Column(name = "duration")
    @NonNull
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "student")
    @NonNull
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject")
    private Subject subject;
}