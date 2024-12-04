package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseSharedDTO;
import org.NAK.YouQuiz.Entity.*;
import org.NAK.YouQuiz.Exception.ExistAnswerValidatioException;
import org.NAK.YouQuiz.Exception.ExistQuestionQuizException;
import org.NAK.YouQuiz.Exception.ValidDateException;
import org.NAK.YouQuiz.Mapper.AnswerValidationMapper;
import org.NAK.YouQuiz.Repository.AnswerValidationRepository;
import org.NAK.YouQuiz.Repository.QuestionRepository;
import org.NAK.YouQuiz.Service.Contract.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnswerValidationServiceImpl implements AnswerValidationService {

    private final AnswerQuestionService answerQuestionService;

    private final AnswerValidationMapper answerValidationMapper;

    private final AnswerValidationRepository answerValidationRepository;

    private final QuestionService questionService;

    private final AnswerService answerService;

    private final AssignmentQuizService assignmentQuizService;


    @Override
    public AnswerValidationResponseSharedDTO createAnswerValidation(AnswerValidationDTO answerValidationDTO) {

        Question existedQuestion = questionService.getQuestionEntityByID(answerValidationDTO.getQuestionId());
        Answer existedAnswer = answerService.getAnswerEntityById(answerValidationDTO.getAnswerId());
        AssignmentQuiz existedAssignmentQuiz = assignmentQuizService.getAssignmentQuizEntityById(answerValidationDTO.getAssignmentQuizId());


        boolean existAnswerValidation = answerValidationRepository.existsByAssignmentQuizIdAndAnswerIdAndQuestionId(existedAssignmentQuiz.getId(), existedAnswer.getId(), answerValidationDTO.getQuestionId());

        if (existAnswerValidation) {
            throw new ExistAnswerValidatioException();
        }

        int exist = (int) existedAssignmentQuiz.getQuiz().getQuestionQuizzes()
                .stream()
                .filter(questionQuiz -> Objects.equals(questionQuiz.getQuestion().getId(), existedQuestion.getId()))
                .count();

        if (exist == 0) {
            throw new ExistQuestionQuizException(existedQuestion.getId(), existedAssignmentQuiz.getId());
        }

        LocalDate currentDate = LocalDate.now();

        if (currentDate.isBefore(existedAssignmentQuiz.getStartDate()) || currentDate.isAfter(existedAssignmentQuiz.getEndDate())) {
            throw new ValidDateException(existedAssignmentQuiz.getStartDate(), existedAssignmentQuiz.getEndDate(), currentDate);
        }


//
//        double point = existedAnswer.getAnswerQuestions()
//                .stream()
//                .filter(answerQuestion -> answerQuestion.getQuestion().getId().equals(existedQuestion.getId()))
//                .mapToDouble(AnswerQuestion::getPoint)
//                .sum();


        Optional<AnswerQuestion> answerQuestion = answerQuestionService.findAnswerQuestion(existedAnswer.getId(), existedQuestion.getId());


        AnswerValidation savedAnswerValidation = answerValidationMapper.toAnswerValidation(answerValidationDTO);

        savedAnswerValidation.setPoints(answerQuestion.get().getPoint());
        savedAnswerValidation.setQuestion(existedQuestion);
        savedAnswerValidation.setAnswer(existedAnswer);
        savedAnswerValidation.setAssignmentQuiz(existedAssignmentQuiz);

        answerValidationRepository.save(savedAnswerValidation);

        double totalPoints = answerValidationRepository.findByAssignmentQuizId(existedAssignmentQuiz.getId())
                .stream()
                .mapToDouble(AnswerValidation::getPoints)
                .sum();

        existedAssignmentQuiz.setScore(totalPoints);
        existedAssignmentQuiz.setResult((totalPoints / existedAssignmentQuiz.getQuiz().getSuccessScore()) * 100);

        assignmentQuizService.save(existedAssignmentQuiz);

        return answerValidationMapper.toAnswerValidationResponseSharedDTO(savedAnswerValidation);
    }

    @Override
    public AnswerValidationResponseDTO updateAnswerValidation(Long id, AnswerValidationDTO answerValidationDTO) {
        AnswerValidation existedAnswerValidation = answerValidationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer validation not found with id: " + id));

        Question existedQuestion = questionService.getQuestionEntityByID(answerValidationDTO.getQuestionId());
        Answer existedAnswer = answerService.getAnswerEntityById(answerValidationDTO.getAnswerId());
        Optional<AnswerQuestion> answerQuestion = answerQuestionService.findAnswerQuestion(existedAnswer.getId(), existedQuestion.getId());


        AssignmentQuiz existedAssignmentQuiz = assignmentQuizService.getAssignmentQuizEntityById(answerValidationDTO.getAssignmentQuizId());

        AnswerValidation savedAnswerValidation = answerValidationMapper.toAnswerValidation(answerValidationDTO);
        savedAnswerValidation.setId(id);
        savedAnswerValidation.setPoints(answerQuestion.get().getPoint());
        savedAnswerValidation.setQuestion(existedQuestion);
        savedAnswerValidation.setAnswer(existedAnswer);
        savedAnswerValidation.setAssignmentQuiz(existedAssignmentQuiz);

        answerValidationRepository.save(savedAnswerValidation);

        double totalPoints = answerValidationRepository.findByAssignmentQuizId(existedAssignmentQuiz.getId())
                .stream()
                .mapToDouble(AnswerValidation::getPoints)
                .sum();

        existedAssignmentQuiz.setScore(totalPoints);
        existedAssignmentQuiz.setResult((totalPoints / existedAssignmentQuiz.getQuiz().getSuccessScore()) * 100);

        assignmentQuizService.save(existedAssignmentQuiz);
        return answerValidationMapper.toAnswerValidationResponseDTO(savedAnswerValidation);

    }

    @Override
    public void deleteAnswerValidation(Long id) {
        if (!answerValidationRepository.existsById(id)) {
            throw new EntityNotFoundException("Answer validation not found with id: " + id);
        }
        answerValidationRepository.deleteById(id);

    }

    @Override
    public AnswerValidationResponseDTO getAnswerValidation(Long id) {
        return answerValidationRepository.findById(id)
                .map(answerValidationMapper::toAnswerValidationResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("answerValidation with id " + id + "not found "));
    }

    @Override
    public List<AnswerValidationResponseDTO> getAnswerValidations() {
        return answerValidationRepository.findAll()
                .stream()
                .map(answerValidationMapper::toAnswerValidationResponseDTO)
                .collect(Collectors.toList());
    }
}
