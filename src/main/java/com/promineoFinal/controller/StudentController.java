package com.promineoFinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.promineoFinal.model.Student;
import com.promineoFinal.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<Student>(studentService.getStudentByID(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        if (isValidStudent(student)) {
            Student savedStudent = studentService.saveStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body("Student created! : " + savedStudent.getName());
        } else {
            return ResponseEntity.badRequest().body("Invalid student data");
        }
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted!", HttpStatus.OK);
    }

    private boolean isValidStudent(Student student) {
        return student != null && student.getName() != null && !student.getName().isEmpty();
    }
}
