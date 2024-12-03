package org.NAK.YouQuiz.DTO.AssignmentQuiz;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "you need to add a reason")
    private String reason;

    @NotNull(message = "you need to add a startDate ")
    private LocalDate startDate;

    @NotNull(message = "you need to add a endDate ")
    private LocalDate endDate;


//    private int attempt;

//    private double score;

//    private double result;

    @NotNull(message = "you need to add a quizId")
    private Long quizId;

    @NotNull(message = "you need to add a studentId")
    private Long studentId;


}
