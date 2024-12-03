package org.NAK.YouQuiz.DTO.Teacher;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseSharedDTO;
import org.NAK.YouQuiz.DTO.User.UserDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TeacherDTO extends UserDTO {

    @NotBlank(message = "you need to add a specialty")
    private String specialty;

    private List<QuizResponseSharedDTO> quizzes;
}
