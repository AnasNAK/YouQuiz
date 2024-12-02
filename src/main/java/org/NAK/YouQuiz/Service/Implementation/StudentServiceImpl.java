package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.Student.StudentDTO;
import org.NAK.YouQuiz.Entity.Student;
import org.NAK.YouQuiz.Mapper.StudentMapper;
import org.NAK.YouQuiz.Repository.StudentRepository;
import org.NAK.YouQuiz.Service.Contract.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    public final StudentRepository studentRepository;

    public final StudentMapper studentMapper;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toStudent(studentDTO);
        return studentMapper.toStudentDTO(studentRepository.save(student));
    }

    @Override
    public List<StudentDTO> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudent(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toStudentDTO).orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {

        Student existedStudent = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
        Student savedStudent = studentMapper.toStudent(studentDTO);
        savedStudent.setId(id);
        studentRepository.save(savedStudent);
        return studentMapper.toStudentDTO(savedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }

        studentRepository.deleteById(id);
    }

    public Student getStudentEntityById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
    }
}
