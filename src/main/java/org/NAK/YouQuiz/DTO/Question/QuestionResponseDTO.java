package org.NAK.YouQuiz.DTO.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseSharedDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseSharedDTO;
import org.NAK.YouQuiz.DTO.Level.LevelResponseSharedDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseSharedDTO;

import org.NAK.YouQuiz.DTO.Subject.SubjectResponseSharedDTO;
import org.NAK.YouQuiz.Enum.QuestionType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
    private Long id;

    private String questionDesc;

    private int answers;

    private int correctAnswers;

    private QuestionType questionType;

    private LevelResponseSharedDTO level;

    private SubjectResponseSharedDTO subject;

    private List<QuestionQuizResponseSharedDTO> questionQuizzes;

    private List<AnswerQuestionResponseSharedDTO> answerQuestions;

    private List<AnswerValidationResponseSharedDTO> answerValidations;

}
