package org.NAK.YouQuiz.Repository;

import org.NAK.YouQuiz.Entity.AnswerQuestion;
import org.NAK.YouQuiz.Entity.Embedded.AnswerQuestionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerQuestionRepository extends JpaRepository<AnswerQuestion, AnswerQuestionKey> {
    Optional<AnswerQuestion> findByAnswerIdAndQuestionId(Long answerId, Long questionId);
}
