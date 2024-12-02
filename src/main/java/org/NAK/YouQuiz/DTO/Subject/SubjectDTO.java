package org.NAK.YouQuiz.DTO.Subject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    private String title;

    private Long parentId;
}
