package org.NAK.YouQuiz.Exception;

public class SingleAnswerException extends RuntimeException {
    public SingleAnswerException()
    {
        super("this question have a type single answer and you add on correctAnswers more than 1");
    }
}
