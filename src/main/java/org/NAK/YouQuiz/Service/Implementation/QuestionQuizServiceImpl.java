package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseDTO;
import org.NAK.YouQuiz.Entity.Embedded.QuestionQuizKey;
import org.NAK.YouQuiz.Entity.Question;
import org.NAK.YouQuiz.Entity.QuestionQuiz;
import org.NAK.YouQuiz.Entity.Quiz;
import org.NAK.YouQuiz.Mapper.QuestionQuizMapper;
import org.NAK.YouQuiz.Repository.QuestionQuizRepository;
import org.NAK.YouQuiz.Service.Contract.QuestionQuizService;
import org.NAK.YouQuiz.Service.Contract.QuestionService;
import org.NAK.YouQuiz.Service.Contract.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionQuizServiceImpl implements QuestionQuizService {

    private final QuestionQuizRepository questionQuizRepository;

    private final QuestionQuizMapper questionQuizMapper;

    private final QuestionService questionService;

    private final QuizService quizService;

    @Override
    public QuestionQuizResponseDTO createQuestionQuiz(QuestionQuizDTO questionQuizDTO) {

        Question existedQuestion = questionService.getQuestionEntityByID(questionQuizDTO.getQuestionId());

        Quiz existedQuiz = quizService.getQuizEntityById(questionQuizDTO.getQuizId());

        QuestionQuiz savedQuestionQuiz = questionQuizMapper.toQuestionQuiz(questionQuizDTO);
        savedQuestionQuiz.setQuestion(existedQuestion);
        savedQuestionQuiz.setQuiz(existedQuiz);

        questionQuizRepository.save(savedQuestionQuiz);

        return questionQuizMapper.toQuestionQuizResponseDTO(savedQuestionQuiz);

    }

    @Override
    public QuestionQuizResponseDTO getQuestionQuiz(QuestionQuizKey questionQuizKey) {
        QuestionQuiz existingQuestionQuiz = questionQuizRepository.findByQuestionIdAndQuizId(questionQuizKey.getQuestionId() ,questionQuizKey.getQuizId())
                .orElseThrow(()-> new EntityNotFoundException("question quiz not found with questionId " + questionQuizKey.getQuestionId() + " and quizId " + questionQuizKey.getQuizId()));

        return questionQuizMapper.toQuestionQuizResponseDTO(existingQuestionQuiz);
    }

    @Override
    public QuestionQuizResponseDTO updateQuestionQuiz(QuestionQuizDTO questionQuizDTO) {

        QuestionQuizKey questionQuizKey = new QuestionQuizKey(
                questionQuizDTO.getQuestionId(),
                questionQuizDTO.getQuizId()
        );

        QuestionQuiz existingQuestionQuiz = questionQuizRepository.findByQuestionIdAndQuizId(questionQuizKey.getQuestionId() ,questionQuizKey.getQuizId())
                .orElseThrow(()-> new EntityNotFoundException("question quiz not found with questionId " + questionQuizKey.getQuestionId() + " and quizId " + questionQuizKey.getQuizId()));


        QuestionQuiz updatedQuestionQuiz = questionQuizMapper.toQuestionQuiz(questionQuizDTO);

        questionQuizRepository.save(updatedQuestionQuiz);
        return questionQuizMapper.toQuestionQuizResponseDTO(updatedQuestionQuiz);
    }

    @Override
    public void deleteQuestionQuiz(QuestionQuizKey questionQuizKey) {
        QuestionQuiz existingQuestionQuiz = questionQuizRepository.findByQuestionIdAndQuizId(questionQuizKey.getQuestionId() ,questionQuizKey.getQuizId())
                .orElseThrow(()-> new EntityNotFoundException("question quiz not found with questionId " + questionQuizKey.getQuestionId() + " and quizId " + questionQuizKey.getQuizId()));

        questionQuizRepository.delete(existingQuestionQuiz);

    }

    @Override
    public List<QuestionQuizResponseDTO> getAllQuestionQuiz() {
        return questionQuizRepository.findAll()
                .stream()
                .map(questionQuizMapper::toQuestionQuizResponseDTO)
                .collect(Collectors.toList());
    }
}
