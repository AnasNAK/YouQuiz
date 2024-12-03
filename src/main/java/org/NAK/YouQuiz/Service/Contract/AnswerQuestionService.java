package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Embedded.AnswerQuestionKey;

import java.util.List;


public interface AnswerQuestionService {

    AnswerQuestionResponseDTO createAnswerQuestion(AnswerQuestionDTO answerQuestionDTO);
    AnswerQuestionResponseDTO updateAnswerQuestion(AnswerQuestionDTO answerQuestionDTO);
    void deleteAnswerQuestion(AnswerQuestionKey answerQuestionKey);
    AnswerQuestionResponseDTO getAnswerQuestion(AnswerQuestionKey answerQuestionKey);
    List<AnswerQuestionResponseDTO> getAnswerQuestions();


}
