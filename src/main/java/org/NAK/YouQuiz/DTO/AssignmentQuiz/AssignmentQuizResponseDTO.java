package org.NAK.YouQuiz.DTO.AssignmentQuiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseSharedDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseSharedDTO;
import org.NAK.YouQuiz.DTO.Student.StudentDTO;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentQuizResponseDTO {

    private Long id;

    private String reason;

    private LocalDate startDate;

    private LocalDate endDate;

    private int attempt;

    private double score;

    private double result;

    private QuizResponseSharedDTO quiz;

    private StudentDTO student;

    private List<AnswerValidationResponseSharedDTO> answerValidations;
}
