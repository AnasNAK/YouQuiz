package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseSharedDTO;
import org.NAK.YouQuiz.Entity.QuestionQuiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {QuizMapper.class ,QuestionMapper.class})
public interface QuestionQuizMapper {
    @Mapping(target="id.questionId",source = "questionId")
    @Mapping(target="id.quizId",source = "quizId")
    @Mapping(target = "question.id",source = "questionId")
    @Mapping(target = "quiz.id",source = "quizId")
    QuestionQuiz toQuestionQuiz(QuestionQuizDTO questionQuizDTO);
    QuestionQuizResponseDTO toQuestionQuizResponseDTO(QuestionQuiz questionQuiz);
    QuestionQuizResponseSharedDTO toQuestionQuizResponseSharedDTO(QuestionQuiz questionQuiz);
}
