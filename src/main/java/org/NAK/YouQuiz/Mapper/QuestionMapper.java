package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.Question.QuestionDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseDTO;
import org.NAK.YouQuiz.Entity.Question;
import org.NAK.YouQuiz.Entity.QuestionQuiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {LevelMapper.class,SubjectMapper.class})
public interface QuestionMapper {

    Question toQuestion(QuestionDTO questionDTO);
    QuestionResponseDTO tooQuestionResponseDTO(Question question);
    QuestionResponseSharedDTO toQuestionResponseSharedDTO(Question question);

}
