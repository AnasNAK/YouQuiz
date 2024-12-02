package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseSharedDTO;

import java.util.List;

public interface AnswerValidationService {

    AnswerValidationResponseSharedDTO createAnswerValidation(AnswerValidationDTO answerValidationDTO);
    AnswerValidationResponseDTO updateAnswerValidation(Long id,AnswerValidationDTO answerValidationDTO);
    void deleteAnswerValidation(Long id);
    AnswerValidationResponseDTO getAnswerValidation(Long id);
    List<AnswerValidationResponseDTO> getAnswerValidations();
}
