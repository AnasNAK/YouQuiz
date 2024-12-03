package org.NAK.YouQuiz.DTO.Answer;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    @NotBlank(message = "you must add a answer")
    private String answer;



}
