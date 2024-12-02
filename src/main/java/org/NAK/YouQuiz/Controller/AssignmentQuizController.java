package org.NAK.YouQuiz.Controller;

import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizDTO;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseDTO;
import org.NAK.YouQuiz.DTO.AssignmentQuiz.AssignmentQuizResponseSharedDTO;
import org.NAK.YouQuiz.Service.Contract.AssignmentQuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignmentQuizzes")
public class AssignmentQuizController {

    private final AssignmentQuizService assignmentQuizService;

    public AssignmentQuizController(AssignmentQuizService assignmentQuizService) {
        this.assignmentQuizService = assignmentQuizService;
    }

    @PostMapping
    public ResponseEntity<AssignmentQuizResponseSharedDTO> createAssignmentQuiz(@RequestBody AssignmentQuizDTO assignmentQuizDTO) {

        AssignmentQuizResponseSharedDTO assignmentQuiz = assignmentQuizService.createAssignmentQuiz(assignmentQuizDTO);
        return new ResponseEntity<>(assignmentQuiz, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AssignmentQuizResponseDTO>> getAllAssignmentQuizzes() {
        List<AssignmentQuizResponseDTO> assignmentQuizList = assignmentQuizService.getAssignmentQuizzes();
        return new ResponseEntity<>(assignmentQuizList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentQuizResponseDTO> getAssignmentQuizById(@PathVariable Long id) {
        AssignmentQuizResponseDTO assignmentQuiz = assignmentQuizService.getAssignmentQuiz(id);
        return new ResponseEntity<>(assignmentQuiz, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AssignmentQuizResponseDTO> updateAssignmentQuiz(@PathVariable Long id, @RequestBody AssignmentQuizDTO assignmentQuizDTO) {

        AssignmentQuizResponseDTO assignmentQuiz = assignmentQuizService.updateAssignmentQuiz(id, assignmentQuizDTO);
        return new ResponseEntity<>(assignmentQuiz, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignmentQuiz(@PathVariable Long id) {
        assignmentQuizService.deleteAssignmentQuiz(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
