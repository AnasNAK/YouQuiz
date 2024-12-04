package org.NAK.YouQuiz.Repository;

import org.NAK.YouQuiz.Entity.AssignmentQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentQuizRepository extends JpaRepository<AssignmentQuiz, Long> {

    int countByQuizIdAndStudentId(Long quizId, Long studentId);
}
