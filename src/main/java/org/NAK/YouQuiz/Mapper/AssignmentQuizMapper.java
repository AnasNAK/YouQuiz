package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizDTO;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseDTO;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseSharedDTO;
import org.NAK.YouQuiz.Entity.AssignmentQuiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {QuizMapper.class, StudentMapper.class})
public interface AssignmentQuizMapper {
    AssignmentQuiz toAssignmentQuiz(AssignmentQuizDTO assignmentQuizDTO);

    AssignmentQuizResponseSharedDTO toAssignmentQuizResponseSharedDTO(AssignmentQuiz assignmentQuiz);

    AssignmentQuizResponseDTO toAssignmentQuizResponseDTO(AssignmentQuiz assignmentQuiz);
}
