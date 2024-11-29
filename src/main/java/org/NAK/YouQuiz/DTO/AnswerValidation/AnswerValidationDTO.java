package org.NAK.YouQuiz.DTO.AnswerValidation;

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


    private double points;

    private Long answerId;

    private Long questionId;

    private Long assignmentQuizId;


}
