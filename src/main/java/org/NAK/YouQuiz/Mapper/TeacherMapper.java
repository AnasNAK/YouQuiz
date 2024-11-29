package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.Teacher.TeacherDTO;
import org.NAK.YouQuiz.Entity.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" ,uses = {QuizMapper.class})
public interface TeacherMapper {

    Teacher toTeacher(TeacherDTO teacherDTO);
    TeacherDTO toTeacherDTO(Teacher teacher);
}
