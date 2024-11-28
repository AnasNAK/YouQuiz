package org.NAK.YouQuiz.DTO.Quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Entity.Teacher;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {
    private String title;
    private int duration;
    private double successScore;
    private boolean allowViewAnswers;
    private boolean allowViewResult;
    private int maxAttempts;
    private String instruction;
    private Long teacherId;
}
