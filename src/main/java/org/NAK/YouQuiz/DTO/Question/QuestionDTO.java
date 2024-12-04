package org.NAK.YouQuiz.DTO.Question;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Entity.Subject;
import org.NAK.YouQuiz.Enum.QuestionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    @NotBlank(message = "You need to add a question description.")
    private String questionDesc;

    @Min(value = 1, message = "The number of answers must be at least 1.")
    private int answers;

    @Min(value = 1, message = "The number of correct answers must be at least 1.")
    private int correctAnswers;

    @NotNull(message = "You need to add a question type.")
    private QuestionType questionType;

    @NotNull(message = "You need to add a levelId.")
    private Long levelId;

    @NotNull(message = "You need to add a subjectId.")
    private Long subjectId;




}
