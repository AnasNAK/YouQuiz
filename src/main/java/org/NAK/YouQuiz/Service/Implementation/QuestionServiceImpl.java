package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.Question.QuestionDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Level;
import org.NAK.YouQuiz.Entity.Question;
import org.NAK.YouQuiz.Entity.Subject;
import org.NAK.YouQuiz.Mapper.AnswerMapper;
import org.NAK.YouQuiz.Mapper.QuestionMapper;
import org.NAK.YouQuiz.Repository.QuestionRepository;
import org.NAK.YouQuiz.Service.Contract.LevelService;
import org.NAK.YouQuiz.Service.Contract.QuestionService;
import org.NAK.YouQuiz.Service.Contract.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final QuestionMapper questionMapper;

    private final LevelService levelService;

    private final SubjectService subjectService;

    @Override
    public QuestionResponseSharedDTO createQuestion(QuestionDTO questionDTO) {

        Level existedLevel = levelService.getLevelEntityById(questionDTO.getLevelId());

        Subject existedSubject = subjectService.getSubjectEntityById(questionDTO.getSubjectId());

        Question savedQuestion = questionMapper.toQuestion(questionDTO);

        savedQuestion.setLevel(existedLevel);
        savedQuestion.setSubject(existedSubject);

        questionRepository.save(savedQuestion);
        return questionMapper.toQuestionResponseSharedDTO(savedQuestion);
    }

    @Override
    public QuestionResponseDTO updateQuestion(Long id,QuestionDTO questionDTO) {
        Question existedQuestion = questionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Question not found with id " + id));

        Level existedLevel = levelService.getLevelEntityById(questionDTO.getLevelId());

        Subject existedSubject = subjectService.getSubjectEntityById(questionDTO.getSubjectId());

        Question savedQuestion = questionMapper.toQuestion(questionDTO);
        savedQuestion.setId(id);
        savedQuestion.setLevel(existedLevel);
        savedQuestion.setSubject(existedSubject);

        questionRepository.save(savedQuestion);

        return questionMapper.tooQuestionResponseDTO(savedQuestion);

    }

    @Override
    public void deleteQuestion(Long id) {
        if (!questionRepository.existsById(id)) {
            throw new EntityNotFoundException("Question not found with id " + id);
        }
        questionRepository.deleteById(id);

    }

    @Override
    public QuestionResponseDTO getQuestion(Long id) {
        return questionRepository.findById(id)
                .map(questionMapper::tooQuestionResponseDTO)
                .orElseThrow(()->new EntityNotFoundException("Question not found with id " + id));
    }

    @Override
    public List<QuestionResponseDTO> getQuestions() {
        return questionRepository.findAll()
                .stream()
                .map(questionMapper::tooQuestionResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Question getQuestionEntityByID(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Question not found with id " + id));
    }
}
