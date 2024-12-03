package org.NAK.YouQuiz.DTO.AnswerValidation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Entity.Answer;
import org.NAK.YouQuiz.Entity.AssignmentQuiz;
import org.NAK.YouQuiz.Entity.Question;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerValidationDTO {


//    private double points;

    @NotNull(message = "you need to add a answerId ")
    private Long answerId;

    @NotNull(message = "you need to add a questionId ")
    private Long questionId;

    @NotNull(message = "you need to add a assignmentQuizId ")
    private Long assignmentQuizId;


}
