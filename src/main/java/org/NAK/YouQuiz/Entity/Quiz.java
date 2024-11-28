package org.NAK.YouQuiz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private int duration;

    @Column(name = "success_score")
    private double successScore;

    @Column(name = "allow_view_answers")
    private boolean allowViewAnswers;

    @Column(name = "allow_view_result")
    private boolean allowViewResult;

    @Column(name = "max_attempts")
    private int maxAttempts;

    @Column(name = "instruction")
    private String instruction;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY)
    private List<AssignmentQuiz> assignmentQuizzes = new ArrayList<>();

    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY)
    private List<QuestionQuiz> questionQuizzes = new ArrayList<>();
}
