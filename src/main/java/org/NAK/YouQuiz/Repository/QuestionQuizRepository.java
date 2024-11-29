package org.NAK.YouQuiz.Repository;

import org.NAK.YouQuiz.Entity.Embedded.QuestionQuizKey;
import org.NAK.YouQuiz.Entity.QuestionQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionQuizRepository extends JpaRepository<QuestionQuiz, QuestionQuizKey> {
}