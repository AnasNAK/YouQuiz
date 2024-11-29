package org.NAK.YouQuiz.DTO.Answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponseSharedDTO {
    private Long id;

    private String answer;

}
