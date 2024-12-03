package org.NAK.YouQuiz.DTO.Question;

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

    @NotBlank(message = "you need to add a question description")
    private String questionDesc;

    @NotNull(message = "you need to add the number of answers")
    private int answers;

    @NotNull(message = "you need to add the number of the correct answers")
    private int correctAnswers;

    @NotBlank(message = "you need to add a question")
    private QuestionType questionType;

    @NotNull(message = "you need to add a levelId")
    private Long levelId;

    @NotNull(message = "you need to add a subjectId")
    private Long subjectId;


}
