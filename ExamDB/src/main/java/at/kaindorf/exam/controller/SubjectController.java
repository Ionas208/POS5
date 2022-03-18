package at.kaindorf.exam.controller;

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
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.Optional;

/*
    Created by: Jonas Seidl
    Date: 04.02.2022
    Time: 10:32
*/
@RestController
@Slf4j
@RequestMapping("subject")
@CrossOrigin(origins = "*")
public class SubjectController {
    @Autowired
    private ClassnameRepository classnameRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/{subject_id}")
    public ResponseEntity<Subject> getSubject(@PathVariable long subject_id){
        return ResponseEntity.of(subjectRepository.findById(subject_id));
    }

    @GetMapping
    public ResponseEntity<Page<Subject>> getAllSubjects(@RequestParam(defaultValue = "0", name = "page") Integer pageNo){
        Pageable page = PageRequest.of(pageNo, 10, Sort.by("longname").ascending());
        Page<Subject> subjects = subjectRepository.findAll(page);
        return ResponseEntity.of(Optional.of(subjects));
    }

    @PostMapping
    public ResponseEntity createSubject(@RequestBody Subject newSubject){
        try{
            newSubject = subjectRepository.save(newSubject);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{subject_id}")
                    .buildAndExpand(newSubject)
                    .toUri();
            return ResponseEntity.created(uri).build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity updateSubject(@RequestBody Subject newSubject){
        try{
            subjectRepository.saveAndFlush(newSubject);
            return ResponseEntity.ok().build();
        }catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping
    public ResponseEntity patchSubject(@RequestParam long subject_id, @RequestBody Subject newSubject){
        if(subjectRepository.existsById(subject_id)){
            Subject subject = subjectRepository.findById(subject_id).get();
            for(Field field: Subject.class.getFields()){
                field.setAccessible(true);
                Object obj = ReflectionUtils.getField(field, newSubject);
                if(obj != null){
                    ReflectionUtils.setField(field, subject, obj);
                }
            }
            subjectRepository.saveAndFlush(subject);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity deleteSubject(@RequestParam long subject_id){
        if(subjectRepository.existsById(subject_id)){
            subjectRepository.deleteById(subject_id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
