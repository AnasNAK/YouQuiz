package org.NAK.YouQuiz.DTO.Quiz;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Entity.Teacher;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {

    @NotBlank(message = "you need to add a Title")
    private String title;

    @Min(value = 1, message = "Duration must be at least 1 minute.")
    @Max(value = 1440, message = "Duration must not exceed 1440 minutes (24 hours)")
    private int duration;

    @DecimalMin(value = "0.0", inclusive = false, message = "Success score must be greater than 0.")
    @DecimalMax(value = "100.0", inclusive = true, message = "Success score must not exceed 100.")
    private double successScore;

    private boolean allowViewAnswers;

    private boolean allowViewResult;

    @Min(value = 1, message = "Max attempts must be at least 1.")
    @Max(value = 10, message = "Max attempts must not exceed 10.")
    private int maxAttempts;

    @Size(max = 500, message = "Instruction must not exceed 500 characters.")
    @NotBlank(message = "you need to add a instruction")
    private String instruction;

    @NotNull(message = "Teacher ID is required.")
    private Long teacherId;
}
