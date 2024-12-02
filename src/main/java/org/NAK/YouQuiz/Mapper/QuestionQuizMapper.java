package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseSharedDTO;
import org.NAK.YouQuiz.Entity.QuestionQuiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {QuizMapper.class})
public interface QuestionQuizMapper {
    QuestionQuiz toQuestionQuiz(QuestionQuizDTO questionQuizDTO);
    QuestionQuizResponseDTO toQuestionQuizResponseDTO(QuestionQuiz questionQuiz);
    QuestionQuizResponseSharedDTO toQuestionQuizResponseSharedDTO(QuestionQuiz questionQuiz);
}
