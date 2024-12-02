package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.Student.StudentDTO;
import org.NAK.YouQuiz.Entity.Student;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    List<StudentDTO> getStudents();
    StudentDTO getStudent(Long id);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
    Student getStudentEntityById(Long id);
}
