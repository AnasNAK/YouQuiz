package org.NAK.YouQuiz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "question_quiz")
public class QuestionQuiz {

    @Id
    @Column(name = "timer")
    private int timer;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Quiz quiz;
}
