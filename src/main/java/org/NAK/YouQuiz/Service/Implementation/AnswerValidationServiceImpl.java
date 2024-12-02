package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Answer;
import org.NAK.YouQuiz.Entity.AnswerValidation;
import org.NAK.YouQuiz.Entity.AssignmentQuiz;
import org.NAK.YouQuiz.Entity.Question;
import org.NAK.YouQuiz.Mapper.AnswerValidationMapper;
import org.NAK.YouQuiz.Repository.AnswerValidationRepository;
import org.NAK.YouQuiz.Service.Contract.AnswerService;
import org.NAK.YouQuiz.Service.Contract.AnswerValidationService;
import org.NAK.YouQuiz.Service.Contract.AssignmentQuizService;
import org.NAK.YouQuiz.Service.Contract.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnswerValidationServiceImpl implements AnswerValidationService {

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

        AnswerValidation savedAnswerValidation = answerValidationMapper.toAnswerValidation(answerValidationDTO);

        savedAnswerValidation.setQuestion(existedQuestion);
        savedAnswerValidation.setAnswer(existedAnswer);
        savedAnswerValidation.setAssignmentQuiz(existedAssignmentQuiz);

        answerValidationRepository.save(savedAnswerValidation);

        return answerValidationMapper.toAnswerValidationResponseSharedDTO(savedAnswerValidation);
    }

    @Override
    public AnswerValidationResponseDTO updateAnswerValidation(Long id, AnswerValidationDTO answerValidationDTO) {
        AnswerValidation existedAnswerValidation = answerValidationRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Answer validation not found with id: " + id));

        Question existedQuestion = questionService.getQuestionEntityByID(answerValidationDTO.getQuestionId());
        Answer existedAnswer = answerService.getAnswerEntityById(answerValidationDTO.getAnswerId());
        AssignmentQuiz existedAssignmentQuiz = assignmentQuizService.getAssignmentQuizEntityById(answerValidationDTO.getAssignmentQuizId());

        AnswerValidation savedAnswerValidation = answerValidationMapper.toAnswerValidation(answerValidationDTO);
        savedAnswerValidation.setId(id);
        savedAnswerValidation.setQuestion(existedQuestion);
        savedAnswerValidation.setAnswer(existedAnswer);
        savedAnswerValidation.setAssignmentQuiz(existedAssignmentQuiz);

        answerValidationRepository.save(savedAnswerValidation);
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
                .orElseThrow(()-> new EntityNotFoundException("answerValidation with id "+id+"not found "));
    }

    @Override
    public List<AnswerValidationResponseDTO> getAnswerValidations() {
        return answerValidationRepository.findAll()
                .stream()
                .map(answerValidationMapper::toAnswerValidationResponseDTO)
                .collect(Collectors.toList());
    }
}
