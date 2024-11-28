package org.NAK.YouQuiz.DTO.Quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.Teacher.TeacherDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponseSharedDTO {
    private Long id;
    private String title;
    private int duration;
    private double successScore;
    private boolean allowViewAnswers;
    private boolean allowViewResult;
    private int maxAttempts;
    private String instruction;

}
