package com.promineoFinal.service;

import java.util.List;
import com.promineoFinal.model.Student;

public interface StudentService {
  
  List<Student> getAllStudents();
  
  Student getStudentByID(Long id);
  
  Student saveStudent(Student student);
  
  Student updateStudent(Student student, Long id);
  
  void deleteStudent(Long id);
  
}
