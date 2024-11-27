package org.NAK.YouQuiz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "answer_validation")
public class AnswerValidation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "points")
    private double points;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToMany
    @JoinTable(
            name = "answer_validation_assignment",
            joinColumns = @JoinColumn(name = "answer_validation_id"),
            inverseJoinColumns = @JoinColumn(name = "assignment_quiz_id")
    )
    private Set<AssignmentQuiz> assignmentQuizzes = new HashSet<>();

}
