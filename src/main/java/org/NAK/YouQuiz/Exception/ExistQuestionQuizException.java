package org.NAK.YouQuiz.Exception;

public class ExistQuestionQuizException extends RuntimeException {
    public ExistQuestionQuizException( Long QuestionId ,Long assignmentQuizId) {
        super("Question not exist with Id"+QuestionId+ "on the AssignmentQuiz" + assignmentQuizId);
    }
}
