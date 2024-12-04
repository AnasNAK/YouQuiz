package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizDTO;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseDTO;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseSharedDTO;
import org.NAK.YouQuiz.Entity.AssignmentQuiz;
import org.NAK.YouQuiz.Entity.Quiz;
import org.NAK.YouQuiz.Entity.Student;
import org.NAK.YouQuiz.Exception.MaxAttemptException;
import org.NAK.YouQuiz.Mapper.AssignmentQuizMapper;
import org.NAK.YouQuiz.Repository.AssignmentQuizRepository;
import org.NAK.YouQuiz.Service.Contract.AssignmentQuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AssignmentQuizServiceImpl implements AssignmentQuizService {

    private final AssignmentQuizRepository assignmentQuizRepository;
    private final AssignmentQuizMapper assignmentQuizMapper;
    private final QuizServiceImpl quizService;
    private final StudentServiceImpl studentService;


    @Override
    public AssignmentQuizResponseSharedDTO createAssignmentQuiz(AssignmentQuizDTO assignmentQuizDTO) {

        Student student = studentService.getStudentEntityById(assignmentQuizDTO.getStudentId());

        Quiz quiz = quizService.getQuizEntityById(assignmentQuizDTO.getQuizId());

        int maxAttempts = quiz.getMaxAttempts();

        if (maxAttempts == assignmentQuizRepository.countByQuizIdAndStudentId(assignmentQuizDTO.getQuizId() ,assignmentQuizDTO.getStudentId())) {
            throw new MaxAttemptException(assignmentQuizDTO.getQuizId(), maxAttempts , assignmentQuizDTO.getStudentId());
        }

        AssignmentQuiz assignmentQuiz = assignmentQuizMapper.toAssignmentQuiz(assignmentQuizDTO);
        assignmentQuiz.setStudent(student);
        assignmentQuiz.setQuiz(quiz);

        AssignmentQuiz savedAssignment = assignmentQuizRepository.save(assignmentQuiz);
        return assignmentQuizMapper.toAssignmentQuizResponseSharedDTO(savedAssignment);

    }

    @Override
    public AssignmentQuizResponseDTO getAssignmentQuiz(Long id) {

        return assignmentQuizRepository.findById(id)
                .map(assignmentQuizMapper::toAssignmentQuizResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("assignment with id " + id + " not found"));
    }

    @Override
    public AssignmentQuizResponseDTO updateAssignmentQuiz(Long id, AssignmentQuizDTO assignmentQuizDTO) {
        AssignmentQuiz existingAssignment = assignmentQuizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AssignmentQuiz with id " + id + " not found"));

            Student student = studentService.getStudentEntityById(assignmentQuizDTO.getStudentId());

            Quiz quiz = quizService.getQuizEntityById(assignmentQuizDTO.getQuizId());

        AssignmentQuiz savedQuiz = assignmentQuizMapper.toAssignmentQuiz(assignmentQuizDTO);

        savedQuiz.setId(id);
        savedQuiz.setQuiz(quiz);
        savedQuiz.setStudent(student);



        AssignmentQuiz updatedAssignment = assignmentQuizRepository.save(savedQuiz);
        return assignmentQuizMapper.toAssignmentQuizResponseDTO(updatedAssignment);
    }
    @Override
    public void deleteAssignmentQuiz(Long id) {
        if (!assignmentQuizRepository.existsById(id)) {
            throw new EntityNotFoundException("Assignment with id " + id + " not found");
        }

        assignmentQuizRepository.deleteById(id);
    }

    @Override
    public List<AssignmentQuizResponseDTO> getAssignmentQuizzes() {
        return assignmentQuizRepository.findAll()
                .stream()
                .map(assignmentQuizMapper::toAssignmentQuizResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentQuiz getAssignmentQuizEntityById(Long id) {
        return assignmentQuizRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("assignment with id :"+id+ "not found "));
    }

    @Override
    public AssignmentQuiz save(AssignmentQuiz assignmentQuiz) {
        return assignmentQuizRepository.save(assignmentQuiz);

    }
}
