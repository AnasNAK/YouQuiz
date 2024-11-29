package org.NAK.YouQuiz.DTO.Level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelResponseDTO {

    private Long id;

    private String description;

    private double maxPoints;

    private double minPoints;

    private List<QuestionResponseSharedDTO> questions;
}
