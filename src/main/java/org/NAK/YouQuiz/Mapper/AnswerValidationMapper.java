package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Answer;
import org.NAK.YouQuiz.Entity.AnswerValidation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" ,uses = {AnswerMapper.class,QuestionMapper.class, AssignmentQuizMapper.class})
public interface AnswerValidationMapper {

    AnswerValidation toAnswerValidation(AnswerValidationDTO answerValidationDTO);
    AnswerValidationResponseDTO toAnswerValidationResponseDTO(AnswerValidation answerValidation);
    AnswerValidationResponseSharedDTO toAnswerValidationResponseSharedDTO(AnswerValidation answerValidation);
}
