package org.NAK.YouQuiz.DTO.AssignmentQuiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentQuizResponseSharedDTO {

    private Long id;

    private String reason;

    private LocalDate startDate;

    private LocalDate endDate;

    private int attempt;

    private double score;

    private double result;
}
