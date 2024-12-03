package org.NAK.YouQuiz.DTO.Student;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseSharedDTO;
import org.NAK.YouQuiz.DTO.User.UserDTO;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StudentDTO extends UserDTO {
    @NotNull(message = "you need to add a register date ")
    private LocalDate registerDate;
    private List<AssignmentQuizResponseSharedDTO> assignmentQuizzes;
}
