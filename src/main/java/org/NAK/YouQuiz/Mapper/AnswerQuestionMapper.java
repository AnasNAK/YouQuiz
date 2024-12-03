package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseSharedDTO;
import org.NAK.YouQuiz.Entity.AnswerQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" ,uses = {QuestionMapper.class , AnswerMapper.class})
public interface AnswerQuestionMapper {
    @Mapping(target = "id.questionId" ,source = "questionId")
    @Mapping(target = "id.answerId" ,source = "answerId")
    @Mapping(target = "question.id" ,source = "questionId")
    @Mapping(target = "answer.id",source="answerId")
    AnswerQuestion toAnswerQuestion(AnswerQuestionDTO answerQuestionDTO);
    AnswerQuestionResponseDTO toAnswerQuestionResponseDTO(AnswerQuestion answerQuestion);
    AnswerQuestionResponseSharedDTO toAnswerQuestionResponseSharedDTO(AnswerQuestion answerQuestion);
}
