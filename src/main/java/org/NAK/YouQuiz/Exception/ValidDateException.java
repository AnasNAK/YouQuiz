package org.NAK.YouQuiz.Exception;

import java.time.LocalDate;

public class ValidDateException extends RuntimeException {
    public ValidDateException(LocalDate startDate, LocalDate endDate, LocalDate now) {
        super("this quiz is between  " + startDate + " and " + endDate +"So you can't add a response because today is " + now);
    }
}
