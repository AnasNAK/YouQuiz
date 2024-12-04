package org.NAK.YouQuiz.Exception;

public class MaxCorrectAnswer extends RuntimeException {
    public MaxCorrectAnswer(long questionId , int correctAnswer) {
        super("you can't add more than " + correctAnswer + "correct answers for the questionId" + questionId );
    }
}
