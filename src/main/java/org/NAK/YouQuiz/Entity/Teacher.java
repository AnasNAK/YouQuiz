package org.NAK.YouQuiz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "teacher_id")
public class Teacher extends User {

    @Column(name = "specialty")
    private String specialty;

    @OneToMany(mappedBy = "teacher" ,cascade = CascadeType.ALL)
    private List<Quiz> quizzes = new ArrayList<>();
}