package org.NAK.YouQuiz.Controller;

import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseSharedDTO;
import org.NAK.YouQuiz.Entity.AnswerQuestion;
import org.NAK.YouQuiz.Entity.Embedded.AnswerQuestionKey;
import org.NAK.YouQuiz.Service.Contract.AnswerQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answerQuestions")
public class AnswerQuestionController {

    private final AnswerQuestionService answerQuestionService;

    public AnswerQuestionController(AnswerQuestionService answerQuestionService) {
        this.answerQuestionService = answerQuestionService;
    }

    @PostMapping
    public ResponseEntity<AnswerQuestionResponseSharedDTO> createAnswerQuestion(@RequestBody AnswerQuestionDTO answerQuestionDTO) {
        AnswerQuestionResponseSharedDTO answerQuestion = answerQuestionService.createAnswerQuestion(answerQuestionDTO);
        return new ResponseEntity<>(answerQuestion, HttpStatus.CREATED);
    }
    @GetMapping("/{questionId}/{AnswerId}")
    public ResponseEntity<AnswerQuestionResponseDTO> getAnswerQuestion(@PathVariable Long questionId, @PathVariable Long AnswerId) {
        AnswerQuestionKey key = new AnswerQuestionKey(AnswerId,questionId);
        AnswerQuestionResponseDTO AnswerQuestion = answerQuestionService.getAnswerQuestion(key);
        return new ResponseEntity<>(AnswerQuestion, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AnswerQuestionResponseDTO>> getAllAnswerQuestions() {
        List<AnswerQuestionResponseDTO> AnswerQuestions = answerQuestionService.getAnswerQuestions();
        return new ResponseEntity<>(AnswerQuestions, HttpStatus.OK);
    }

    @PatchMapping("/{questionId}/{AnswerId}")
    public ResponseEntity<AnswerQuestionResponseDTO> updateAnswerQuestion(@PathVariable Long questionId, @PathVariable Long AnswerId, @RequestBody AnswerQuestionDTO answerQuestionDTO) {

        answerQuestionDTO.setAnswerId(AnswerId);
        answerQuestionDTO.setQuestionId(questionId);
        AnswerQuestionResponseDTO AnswerQuestion = answerQuestionService.updateAnswerQuestion(answerQuestionDTO);
        return new ResponseEntity<>(AnswerQuestion, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{questionId}/{AnswerId}")
    public ResponseEntity<String> deleteAnswerQuestion(@PathVariable Long questionId, @PathVariable Long AnswerId) {
        AnswerQuestionKey key = new AnswerQuestionKey(AnswerId,questionId);
        answerQuestionService.deleteAnswerQuestion(key);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
