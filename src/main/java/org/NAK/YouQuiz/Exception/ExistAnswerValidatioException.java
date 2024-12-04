package org.NAK.YouQuiz.Exception;

public class ExistAnswerValidatioException extends RuntimeException {
    public ExistAnswerValidatioException( ) {
        super("Answer is already exist");
    }
}
