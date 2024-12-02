package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.Quiz.QuizDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" ,uses = {TeacherMapper.class , AnswerMapper.class })
public interface QuizMapper {

    Quiz toQuiz(QuizDTO quizDTO);
    QuizResponseDTO toQuizResponseDTO(Quiz quiz);
    QuizResponseSharedDTO toQuizResponseSharedDTO(Quiz quiz);
}
