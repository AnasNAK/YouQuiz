package org.NAK.YouQuiz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.Enum.QuestionType;

import java.util.ArrayList;
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

    @Column(name = "question_description")
    private String questionDesc;

    @Column(name = "answers")
    private int answers;

    @Column(name = "correct_answers")
    private int correctAnswers;

    @Column(name = "question_type")
    private QuestionType questionType;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
    private List<QuestionQuiz> questionQuizzes = new ArrayList<>();

    @ManyToOne
    private Level level;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
    private List<AnswerQuestion> answerQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "question" ,fetch = FetchType.LAZY)
    private List<AnswerValidation> answerValidations = new ArrayList<>();
}
