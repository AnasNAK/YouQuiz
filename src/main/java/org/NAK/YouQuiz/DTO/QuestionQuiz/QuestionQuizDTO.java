package org.NAK.YouQuiz.DTO.QuestionQuiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionQuizDTO {

    private Long questionId;

    private Long quizId;

    private int timer;



}
