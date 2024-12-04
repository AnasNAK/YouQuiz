package org.NAK.YouQuiz.Repository;

import org.NAK.YouQuiz.Entity.AnswerValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerValidationRepository extends JpaRepository<AnswerValidation, Long> {
     List<AnswerValidation> findByAssignmentQuizId(Long quizId);
     boolean existsByAssignmentQuizIdAndAnswerIdAndQuestionId( Long assignmentQuizId, Long answerId, Long questionId);
}
