package org.NAK.YouQuiz.DTO.AnswerQuestion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseSharedDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerQuestionResponseSharedDTO {

    private Long questionId;

    private Long answerId;

    private double point;

}
