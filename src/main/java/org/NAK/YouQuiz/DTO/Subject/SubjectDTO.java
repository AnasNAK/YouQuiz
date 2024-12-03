package org.NAK.YouQuiz.DTO.Subject;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    @NotBlank(message = "you need to add a title ")
    private String title;

    private Long parentId;
}
