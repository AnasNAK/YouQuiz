package org.NAK.YouQuiz.DTO.Level;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelDTO {


    @NotBlank(message = "you need to add a description")
    private String description;

    @NotNull(message = "you need to add a max point")
    private double maxPoints;

    @NotNull(message = "you need to add a min point")
    private double minPoints;


}
