package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Embedded.QuestionQuizKey;
import org.NAK.YouQuiz.Entity.QuestionQuiz;

import java.util.List;

public interface QuestionQuizService {
    QuestionQuizResponseDTO createQuestionQuiz(QuestionQuizDTO questionQuizDTO);
    QuestionQuizResponseDTO getQuestionQuiz(QuestionQuizKey questionQuizKey);
    QuestionQuizResponseDTO updateQuestionQuiz(QuestionQuizDTO questionQuizDTO);
    void deleteQuestionQuiz(QuestionQuizKey questionQuizKey);
    List<QuestionQuizResponseDTO> getAllQuestionQuiz();
}
