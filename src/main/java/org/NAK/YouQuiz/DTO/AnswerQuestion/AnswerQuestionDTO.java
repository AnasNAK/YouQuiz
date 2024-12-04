package org.NAK.YouQuiz.DTO.AnswerQuestion;

import jakarta.validation.constraints.Min;
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

    @NotNull(message = "you need to add a point to this answer")
    @Min(value = 0, message = "th point cannot be small than 0")
    private double point;


}
