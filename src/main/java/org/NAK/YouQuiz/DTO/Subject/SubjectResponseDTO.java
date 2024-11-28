package org.NAK.YouQuiz.DTO.Subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Entity.Subject;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponseDTO {
    private Long id;

    private String title;

    private SubjectResponseDTO parent;
    //    private List<QuestionDTO> questions ;

}
