package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.Teacher.TeacherDTO;
import org.NAK.YouQuiz.Entity.Teacher;
import org.NAK.YouQuiz.Mapper.TeacherMapper;
import org.NAK.YouQuiz.Repository.TeacherRepository;
import org.NAK.YouQuiz.Service.Contract.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    public final TeacherRepository teacherRepository;

    public final TeacherMapper teacherMapper;


    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher savedTeacher = teacherMapper.toTeacher(teacherDTO);
        teacherRepository.save(savedTeacher);
        return teacherMapper.toTeacherDTO(savedTeacher);
    }

    @Override
    public TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO) {
        Teacher existedTeacher = teacherRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Teacher with id " + id + " not found"));

        Teacher savedTeacher = teacherMapper.toTeacher(teacherDTO);

        savedTeacher.setId(id);
        teacherRepository.save(savedTeacher);
        return teacherMapper.toTeacherDTO(savedTeacher);
    }

    @Override
    public void deleteTeacher(Long id) {

        if (!teacherRepository.existsById(id)) {
            throw new EntityNotFoundException("Teacher with id " + id + " not found");
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public List<TeacherDTO> getTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toTeacherDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .map(teacherMapper::toTeacherDTO)
                .orElseThrow(()-> new EntityNotFoundException("Teacher with id " + id + " not found"));
    }

    @Override
    public Teacher getTeacherEntityById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Teacher with id " + id + " not found"));
    }
}
