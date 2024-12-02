package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseSharedDTO;
import org.NAK.YouQuiz.Entity.AnswerQuestion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" ,uses = {QuestionMapper.class})
public interface AnswerQuestionMapper {
    AnswerQuestion toAnswerQuestion(AnswerQuestionDTO answerQuestionDTO);
    AnswerQuestionResponseDTO toAnswerQuestionResponseDTO(AnswerQuestion answerQuestion);
    AnswerQuestionResponseSharedDTO toAnswerQuestionResponseSharedDTO(AnswerQuestion answerQuestion);
}
