package org.NAK.YouQuiz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Entity.Embedded.QuestionQuizKey;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "question_quiz")
public class QuestionQuiz {

    @EmbeddedId
    private QuestionQuizKey id;

    @Column(name = "timer")
    private int timer;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @MapsId("quizId")
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
