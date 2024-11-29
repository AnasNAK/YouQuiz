package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.Answer.AnswerDTO;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseDTO;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {AnswerValidationMapper.class, AnswerQuestionMapper.class})
public interface AnswerMapper {
    Answer toAnswer(AnswerDTO answerDTO);
    AnswerResponseSharedDTO toAnswerResponseSharedDTO(Answer answer);
    AnswerResponseDTO toAnswerResponseDTO(Answer answer);
}
