package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.Teacher.TeacherDTO;
import org.NAK.YouQuiz.Entity.Teacher;

import java.util.List;

public interface TeacherService {

    TeacherDTO createTeacher(TeacherDTO teacherDTO);
    TeacherDTO updateTeacher(Long id,TeacherDTO teacherDTO);
    void deleteTeacher(Long id);
    List<TeacherDTO> getTeachers();
    TeacherDTO getTeacherById(Long id);
    Teacher getTeacherEntityById(Long id);


}
