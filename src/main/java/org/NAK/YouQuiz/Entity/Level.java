package org.NAK.YouQuiz.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "max_points")
    private double maxPoints;

    @Column(name = "min_points")
    private double minPoints;

    @OneToMany(mappedBy = "level")
    private List<Question> questions;
}
