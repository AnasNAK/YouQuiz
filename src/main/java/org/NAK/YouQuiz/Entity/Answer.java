package org.NAK.YouQuiz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "answer")
    private String answer;

    @OneToMany(mappedBy = "answer" ,fetch = FetchType.LAZY)
    private List<AnswerQuestion> answerQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "answer" ,fetch = FetchType.LAZY)
    private List<AnswerValidation> answerValidations = new ArrayList<>();
}
