package org.NAK.YouQuiz.DTO.AnswerQuestion;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerQuestionDTO {

    @NotNull(message = "you need to add a questionId ")
    private Long questionId;

    @NotNull(message = "you need to add a answerId ")
    private Long answerId;

//    private double point;


}
