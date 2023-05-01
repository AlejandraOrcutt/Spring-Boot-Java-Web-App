package com.promineoFinal.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.promineoFinal.model.Student;
import com.promineoFinal.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent == null) {
            return null;
        }
        existingStudent.setName(student.getName());
        existingStudent.setInstrument(student.getInstrument());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
