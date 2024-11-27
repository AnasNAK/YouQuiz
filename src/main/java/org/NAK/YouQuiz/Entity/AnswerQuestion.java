package org.NAK.YouQuiz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Entity.Embedded.AnswerQuestionKey;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "answer_question")
public class AnswerQuestion {

    @EmbeddedId
    private AnswerQuestionKey id;

    @Column(name = "point")
    private double point;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @MapsId("answerId")
    @JoinColumn(name = "answer_id")
    private Answer answer;



}
