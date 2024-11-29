package org.NAK.YouQuiz.DTO.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Enum.QuestionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseSharedDTO {
    private Long id;

    private String question;

    private int answers;

    private int correctAnswers;

    private QuestionType questionType;

}
