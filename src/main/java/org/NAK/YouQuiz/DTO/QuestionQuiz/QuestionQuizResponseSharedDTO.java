package org.NAK.YouQuiz.DTO.QuestionQuiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseSharedDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionQuizResponseSharedDTO {

    private Long questionId;

    private Long quizId;

    private int timer;
}
