package org.NAK.YouQuiz.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends User {

    @Column(name = "register_date")
    private LocalDate registerDate;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AssignmentQuiz> assignmentQuizzes = new ArrayList<>();
}