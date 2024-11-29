package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.Student.StudentDTO;
import org.NAK.YouQuiz.Entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" ,uses = {AssignmentQuizMapper.class})
public interface StudentMapper {
    Student toStudent(StudentDTO studentDTO);
    StudentDTO toStudentDTO(Student student);
}
