package org.NAK.YouQuiz.DTO.QuestionQuiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseSharedDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionQuizResponseDTO {

    private QuestionResponseSharedDTO question;

    private QuizResponseSharedDTO quiz;

    private int timer;
}
