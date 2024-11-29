package org.NAK.YouQuiz.DTO.AnswerValidation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseSharedDTO;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseSharedDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerValidationResponseDTO {
    private Long id;

    private double points;

    private AnswerResponseSharedDTO answer;

    private QuestionResponseSharedDTO question;

    private AssignmentQuizResponseSharedDTO assignmentQuiz;
}
