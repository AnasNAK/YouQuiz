package org.NAK.YouQuiz.Entity.Embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionQuizKey implements Serializable {

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "Quiz_id")
    private Long quizId;
}