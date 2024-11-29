package org.NAK.YouQuiz.DTO.AssignmentQuiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseSharedDTO;
import org.NAK.YouQuiz.Entity.AnswerValidation;
import org.NAK.YouQuiz.Entity.Quiz;
import org.NAK.YouQuiz.Entity.Student;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentQuizDTO {

    private String reason;

    private LocalDate startDate;

    private LocalDate endDate;

    private int attempt;

    private double score;

    private double result;

    private Long quizId;

    private Long studentId;


}
