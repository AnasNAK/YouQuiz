package org.NAK.YouQuiz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Enum.QuestionType;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "answers")
    private int answers;

    @Column(name = "correct_answers")
    private int correctAnswers;

    @Column(name = "question_type")
    private QuestionType questionType;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
    private List<QuestionQuiz> questionQuizzes;

    @ManyToOne
    private Level level;

    @ManyToOne
    private Subject subject;
}
