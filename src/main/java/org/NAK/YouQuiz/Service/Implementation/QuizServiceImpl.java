package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.Quiz.QuizDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Quiz;
import org.NAK.YouQuiz.Entity.Teacher;
import org.NAK.YouQuiz.Mapper.QuizMapper;
import org.NAK.YouQuiz.Repository.QuizRepository;
import org.NAK.YouQuiz.Service.Contract.QuizService;
import org.NAK.YouQuiz.Service.Contract.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private final QuizMapper quizMapper;

    private final TeacherService teacherService;

    @Override
    public QuizResponseSharedDTO createQuiz(QuizDTO quizDTO) {

        Teacher teacher = teacherService.getTeacherEntityById(quizDTO.getTeacherId());

        Quiz savedQuiz = quizMapper.toQuiz(quizDTO);
        savedQuiz.setTeacher(teacher);
        Quiz quiz = quizRepository.save(savedQuiz);
        return quizMapper.toQuizResponseSharedDTO(quiz);
    }

    @Override
    public QuizResponseDTO updateQuiz(Long id,QuizDTO quizDTO) {
        Quiz existingQuiz = quizRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quiz with id " + id + " not found"));

        Teacher teacher = teacherService.getTeacherEntityById(quizDTO.getTeacherId());

        Quiz savedQuiz = quizMapper.toQuiz(quizDTO);
        savedQuiz.setTeacher(teacher);
        savedQuiz.setId(id);
        Quiz updatedQuiz = quizRepository.save(savedQuiz);
        return quizMapper.toQuizResponseDTO(updatedQuiz);

    }

    @Override
    public void deleteQuiz(Long id) {
        if (!quizRepository.existsById(id)) {
            throw new EntityNotFoundException("Quiz with id " + id + " not found");

        }
        quizRepository.deleteById(id);

    }

    @Override
    public QuizResponseDTO getQuiz(Long id) {
        return quizRepository.findById(id)
                .map(quizMapper::toQuizResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Quiz with id " + id + " not found"));
    }

    @Override
    public List<QuizResponseDTO> getQuizzes() {
        return quizRepository.findAll()
                .stream()
                .map(quizMapper::toQuizResponseDTO)
                .collect(Collectors.toList());
    }

    public Quiz getQuizEntityById(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz with id "+id+ " not found"));
    }
}
