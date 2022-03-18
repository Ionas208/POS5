package at.kaindorf.exam.controller;

import at.kaindorf.exam.pojos.Exam;
import at.kaindorf.exam.pojos.Student;
import at.kaindorf.exam.pojos.Subject;
import at.kaindorf.exam.repo.ClassnameRepository;
import at.kaindorf.exam.repo.ExamRepository;
import at.kaindorf.exam.repo.StudentRepository;
import at.kaindorf.exam.repo.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

/*
    Created by: Jonas Seidl
    Date: 04.02.2022
    Time: 10:32
*/
@RestController
@Slf4j
@RequestMapping("exam")
@CrossOrigin(origins = "*")
public class ExamController {
    @Autowired
    private ClassnameRepository classnameRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;


    @GetMapping("/getByStudent/{studentId}")
    public ResponseEntity<List<Exam>> getByStudent(@PathVariable Long studentId) {
        if(studentId == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Exam> exams = examRepository.findAllByStudent(student.get());
        return ResponseEntity.of(Optional.of(exams));
    }

    @GetMapping("/getAllSubjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return ResponseEntity.of(Optional.of(subjects));
    }

    @GetMapping("/getById")
    public ResponseEntity<Exam> getById(@RequestParam Long exam_id) {
        return ResponseEntity.of(examRepository.findById(exam_id));
    }

    @PatchMapping("/update")
    public ResponseEntity update(@RequestParam Long exam_id,
                                 @RequestBody Exam newExam) {
        if(exam_id == null || newExam == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Exam> exam = examRepository.findById(exam_id);
        if(exam.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        for (Field field : Exam.class.getDeclaredFields()) {
            if (field.getName().equals("DTF")) continue;
            field.setAccessible(true);
            Object obj = ReflectionUtils.getField(field, newExam);
            if (obj != null) {
                System.out.println(field.getName() + obj);
                ReflectionUtils.setField(field, exam.get(), obj);
            }
        }
        examRepository.saveAndFlush(exam.get());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove")
    public ResponseEntity remove(@RequestParam Long exam_id) {
        if(exam_id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Exam> exam = examRepository.findById(exam_id);
        if(exam.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        examRepository.delete(exam.get());
        return ResponseEntity.ok().build();
    }
}
