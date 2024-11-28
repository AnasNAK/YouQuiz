package org.NAK.YouQuiz.DTO.Subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponseSharedDTO {
    private Long id;

    private String title;

    private SubjectResponseDTO parent;
}
