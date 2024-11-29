package org.NAK.YouQuiz.DTO.Answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseSharedDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseSharedDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponseDTO {
    private Long id;

    private String answer;

    private List<AnswerQuestionResponseSharedDTO> answerQuestions ;

    private List<AnswerValidationResponseSharedDTO> answerValidations ;
}
