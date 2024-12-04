package org.NAK.YouQuiz.Exception;

public class MaxAttemptException extends RuntimeException {
    public MaxAttemptException(Long quizId, int attempt, Long student) {
        super(String.format("quizId %d reached the max attempt %d for this student %d ", quizId, attempt, student));
    }
}
