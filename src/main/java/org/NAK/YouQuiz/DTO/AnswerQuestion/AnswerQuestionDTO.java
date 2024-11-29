package org.NAK.YouQuiz.DTO.AnswerQuestion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerQuestionDTO {

    private Long questionId;

    private Long answerId;

    private double point;


}
