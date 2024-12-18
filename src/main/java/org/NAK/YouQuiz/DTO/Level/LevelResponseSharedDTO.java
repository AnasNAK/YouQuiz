package org.NAK.YouQuiz.DTO.Level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelResponseSharedDTO {

    private Long id;

    private String description;

    private double maxPoints;

    private double minPoints;
}
