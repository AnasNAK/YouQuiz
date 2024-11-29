package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseDTO;
import org.NAK.YouQuiz.Entity.Question;
import org.NAK.YouQuiz.Entity.QuestionQuiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {QuestionQuizMapper.class,LevelMapper.class,SubjectMapper.class, AnswerQuestionMapper.class, AnswerValidationMapper.class})
public interface QuestionMapper {

    Question toQuestion(QuestionQuizDTO questionQuizDTO);
    QuestionQuizResponseDTO tooQuestionQuizResponseDTO(Question question);
    QuestionResponseSharedDTO toQuestionResponseSharedDTO(Question question);

}
