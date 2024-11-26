package org.NAK.YouQuiz.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Quiz_assignment")
public class AssignmentQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "reason")
    private String reason;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "attempt")
    private int attempt;

    @Column(name = "score")
    private double score;

    @Column(name = "result")
    private double result;


    @ManyToOne
    private Quiz quiz;

    @ManyToOne
    private Student student;
}
