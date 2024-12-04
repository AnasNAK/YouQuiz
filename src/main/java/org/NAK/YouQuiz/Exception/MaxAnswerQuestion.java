package org.NAK.YouQuiz.Exception;

public class MaxAnswerQuestion extends RuntimeException {
    public MaxAnswerQuestion(int maxAnswers) {
        super("this question can have just " + maxAnswers + " answers not more");
    }
}
