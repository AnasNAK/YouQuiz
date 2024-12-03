package org.NAK.YouQuiz.DTO.QuestionQuiz;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionQuizDTO {

    @NotNull(message = "you need to add a questionId ")
    private Long questionId;

    @NotNull(message = "you need to add a quizId")
    private Long quizId;

    @NotNull(message = "you need to add a timer")
    private int timer;



}
