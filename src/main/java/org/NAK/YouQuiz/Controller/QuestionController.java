package org.NAK.YouQuiz.Controller;

import org.NAK.YouQuiz.DTO.Question.QuestionDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseDTO;
import org.NAK.YouQuiz.DTO.Question.QuestionResponseSharedDTO;
import org.NAK.YouQuiz.Service.Contract.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionResponseSharedDTO> createQuestion(@RequestBody QuestionDTO questionDTO) {
        QuestionResponseSharedDTO question = questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> getQuestion(@PathVariable Long id) {

        QuestionResponseDTO question = questionService.getQuestion(id);
        return new ResponseEntity<>(question, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getQuestions() {
        List<QuestionResponseDTO> questions = questionService.getQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> updateQuestion(@PathVariable Long id, @RequestBody QuestionDTO questionDTO) {
        QuestionResponseDTO question = questionService.updateQuestion(id, questionDTO);
        return new ResponseEntity<>(question, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
