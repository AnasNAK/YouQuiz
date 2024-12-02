package org.NAK.YouQuiz.Controller;

import org.NAK.YouQuiz.DTO.Quiz.QuizDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseSharedDTO;
import org.NAK.YouQuiz.Service.Contract.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<QuizResponseSharedDTO> createQuiz(@RequestBody QuizDTO quizDTO) {
        QuizResponseSharedDTO quiz = quizService.createQuiz(quizDTO);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuizResponseDTO>> getAllQuizzes() {
        List<QuizResponseDTO> Quizzes = quizService.getQuizzes();
        return new ResponseEntity<>(Quizzes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> getQuizById(@PathVariable Long id) {
        QuizResponseDTO quiz = quizService.getQuiz(id);
        return new ResponseEntity<>(quiz, HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> updateQuiz(@PathVariable Long id, @RequestBody QuizDTO quizDTO) {
        QuizResponseDTO quiz = quizService.updateQuiz(id, quizDTO);
        return new ResponseEntity<>(quiz, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

