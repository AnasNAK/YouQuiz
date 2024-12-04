package org.NAK.YouQuiz.Exception;

public class MaxWrongAnswers extends RuntimeException {
    public MaxWrongAnswers(Long QuestionId , int wrongAnswers ) {
        super("you cannot add more than "+wrongAnswers+" false answers to questionId : "+QuestionId);
    }
}
