package org.NAK.YouQuiz.Exception;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.NAK.YouQuiz.DTO.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExistAnswerValidatioException.class)
    public ResponseEntity<ErrorResponseDTO> handleExistAnswerValidatioException(ExistAnswerValidatioException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxAnswerQuestion.class)
    public ResponseEntity<ErrorResponseDTO> handleMaxAnswerQuestion(MaxAnswerQuestion ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidDateException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidDateException(ValidDateException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SingleAnswerException.class)
    public ResponseEntity<ErrorResponseDTO> handleSingleAnswerException(SingleAnswerException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxWrongAnswers.class)
    public ResponseEntity<ErrorResponseDTO> handleMaxWrongAnswers(MaxWrongAnswers ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxCorrectAnswer.class)
    public ResponseEntity<ErrorResponseDTO> handleMaxCorrectAnswer(MaxCorrectAnswer ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PointsException.class)
    public ResponseEntity<ErrorResponseDTO> handlePointsException(PointsException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistQuestionQuizException.class)
    public ResponseEntity<ErrorResponseDTO> handleSubjectQuestionException(ExistQuestionQuizException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SubjectQuestionException.class)
    public ResponseEntity<ErrorResponseDTO> handleSubjectQuestionException(SubjectQuestionException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxAttemptException.class)
    public ResponseEntity<ErrorResponseDTO> handleMaxAttemptException(MaxAttemptException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            validationErrors.put(error.getField(), error.getDefaultMessage());
        }
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("VALIDATION_FAILED", validationErrors.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleConstraintViolationException(ConstraintViolationException ex) {
        String validationErrors = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .reduce("", (acc, error) -> acc + error + "; ");
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("VALIDATION_FAILED", validationErrors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGlobalException(Exception ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("INTERNAL_SERVER_ERROR", "An unexpected error occurred");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
