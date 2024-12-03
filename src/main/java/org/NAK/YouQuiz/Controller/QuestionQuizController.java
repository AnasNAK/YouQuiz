package org.NAK.YouQuiz.Controller;


import jakarta.validation.Valid;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseDTO;
import org.NAK.YouQuiz.DTO.QuestionQuiz.QuestionQuizResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Embedded.QuestionQuizKey;
import org.NAK.YouQuiz.Service.Contract.QuestionQuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionQuizzes")
public class QuestionQuizController {

    private final QuestionQuizService questionQuizService;

    public QuestionQuizController(QuestionQuizService questionQuizService) {
        this.questionQuizService = questionQuizService;
    }

    @PostMapping
    public ResponseEntity<QuestionQuizResponseDTO> createQuestionQuiz(@Valid @RequestBody QuestionQuizDTO questionQuizDTO) {
        QuestionQuizResponseDTO QuestionQuiz = questionQuizService.createQuestionQuiz(questionQuizDTO);
        return new ResponseEntity<>(QuestionQuiz, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionQuizResponseDTO>> getAllQuestionQuizzes() {
        List<QuestionQuizResponseDTO> QuestionQuizzes = questionQuizService.getAllQuestionQuiz();
        return new ResponseEntity<>(QuestionQuizzes, HttpStatus.OK);
    }

    @GetMapping("/{quizId}/{questionId}")
    public ResponseEntity<QuestionQuizResponseDTO> getQuestionQuiz(@PathVariable Long quizId, @PathVariable Long questionId) {
        QuestionQuizKey questionQuizKey = new QuestionQuizKey(quizId,questionId);
        QuestionQuizResponseDTO QuestionQuiz = questionQuizService.getQuestionQuiz(questionQuizKey);
        return new ResponseEntity<>(QuestionQuiz, HttpStatus.OK);
    }

    @PatchMapping("/{quizId}/{questionId}")
    public ResponseEntity<QuestionQuizResponseDTO> updateQuestionQuiz(@PathVariable Long quizId, @PathVariable Long questionId
                                                                    ,@Valid @RequestBody QuestionQuizDTO questionQuizDTO) {
        questionQuizDTO.setQuizId(quizId);
        questionQuizDTO.setQuestionId(questionId);
        QuestionQuizResponseDTO questionQuiz = questionQuizService.updateQuestionQuiz(questionQuizDTO);
        return new ResponseEntity<>(questionQuiz, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{quizId}/{questionId}")
    public ResponseEntity<Void> deleteQuestionQuiz(@PathVariable Long quizId, @PathVariable Long questionId) {
        QuestionQuizKey questionQuizKey = new QuestionQuizKey(quizId,questionId);
        questionQuizService.deleteQuestionQuiz(questionQuizKey);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
