package org.NAK.YouQuiz.DTO.Subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Subject;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponseDTO {

    private Long id;

    private String title;

    private SubjectResponseSharedDTO parent;

    private List<SubjectResponseDTO> subSubjects;

    private List<QuestionResponseSharedDTO> questions ;

}
