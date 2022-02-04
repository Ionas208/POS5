package at.kaindorf.exam.controller;

import at.kaindorf.exam.pojos.Classname;
import at.kaindorf.exam.pojos.Exam;
import at.kaindorf.exam.pojos.Student;
import at.kaindorf.exam.pojos.Subject;
import at.kaindorf.exam.repo.ClassnameRepository;
import at.kaindorf.exam.repo.ExamRepository;
import at.kaindorf.exam.repo.StudentRepository;
import at.kaindorf.exam.repo.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
    Created by: Jonas Seidl
    Date: 04.02.2022
    Time: 10:32
*/
@RestController
@Slf4j
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    @Autowired
    private ClassnameRepository classnameRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/getByClassname")
    public ResponseEntity<Page<Student>> getStudentsByClassname(
            @RequestParam Long classname_id,
            @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 10, Sort.by("lastname").ascending());

        Classname classname = classnameRepository.findById(classname_id).orElse(null);
        Page<Student> students = studentRepository.findAllByClassname(classname, page);

        return ResponseEntity.of(Optional.of(students));
    }

    @PostMapping("/addExam")
    public ResponseEntity addExam(@RequestParam Long student_id,
                                  @RequestParam Long subject_id,
                                  @RequestBody Exam exam) {
        System.out.println(exam);
        if(student_id == null || exam == null || subject_id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Student> student = studentRepository.findById(student_id);
        if(student.isEmpty()) {
            System.out.println("Student not found");
            return ResponseEntity.notFound().build();
        }
        Optional<Subject> subject = subjectRepository.findById(subject_id);
        if(subject.isEmpty()) {
            System.out.println("Subject not found");
            return ResponseEntity.notFound().build();
        }
        exam.setStudent(student.get());
        exam.setSubject(subject.get());
        examRepository.save(exam);
        return ResponseEntity.ok().build();
    }
}
