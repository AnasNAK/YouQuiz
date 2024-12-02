package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.Question.QuestionDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Question;

import java.util.List;

public interface QuestionService {
    QuestionResponseSharedDTO createQuestion(QuestionDTO questionDTO);
    QuestionResponseDTO updateQuestion(Long id,QuestionDTO questionDTO);
    void deleteQuestion(Long id);
    QuestionResponseDTO getQuestion(Long id);
    List<QuestionResponseDTO> getQuestions();
    Question getQuestionEntityByID(Long id);
}
