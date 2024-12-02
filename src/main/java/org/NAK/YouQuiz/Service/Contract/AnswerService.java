package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.Answer.AnswerDTO;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseDTO;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Answer;

import java.util.List;

public interface AnswerService {
    AnswerResponseSharedDTO createAnswer(AnswerDTO answerDTO);
    AnswerResponseDTO updateAnswer(Long id ,AnswerDTO answerDTO);
    void deleteAnswer(Long id);
    AnswerResponseDTO getAnswer(Long id);
    List<AnswerResponseDTO> getAnswers();
    Answer getAnswerEntityById(Long id);
}
