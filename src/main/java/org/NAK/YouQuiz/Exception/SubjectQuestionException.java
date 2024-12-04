package org.NAK.YouQuiz.Exception;

public class SubjectQuestionException extends RuntimeException {
    public SubjectQuestionException(Long subject ) {
        super(" the Subject " + subject + " cannot have a questions because it have a childs");
    }
}
