package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizDTO;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseDTO;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseSharedDTO;

import java.util.List;


public interface AssignmentQuizService {

    AssignmentQuizResponseSharedDTO createAssignmentQuiz(AssignmentQuizDTO assignmentQuizDTO);
    AssignmentQuizResponseDTO getAssignmentQuiz(Long id);
    AssignmentQuizResponseDTO updateAssignmentQuiz(Long id, AssignmentQuizDTO assignmentQuizDTO);
    void deleteAssignmentQuiz(Long id);
    List<AssignmentQuizResponseDTO> getAssignmentQuizzes();
}
