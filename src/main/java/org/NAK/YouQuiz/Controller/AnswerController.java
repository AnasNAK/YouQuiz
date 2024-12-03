package org.NAK.YouQuiz.Controller;

import jakarta.validation.Valid;
import org.NAK.YouQuiz.DTO.Answer.AnswerDTO;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseDTO;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseSharedDTO;
import org.NAK.YouQuiz.Service.Contract.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<AnswerResponseSharedDTO> createAnswer(@Valid @RequestBody AnswerDTO answerDTO) {
        AnswerResponseSharedDTO answer = answerService.createAnswer(answerDTO);
        return new ResponseEntity<>(answer, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> getAnswer(@PathVariable Long id) {
        AnswerResponseDTO answer = answerService.getAnswer(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<AnswerResponseDTO>> getAllAnswers() {
        List<AnswerResponseDTO> answers = answerService.getAnswers();
        return new ResponseEntity<>(answers,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> updateAnswer(@PathVariable Long id,@Valid @RequestBody AnswerDTO answerDTO) {
        AnswerResponseDTO answer = answerService.updateAnswer(id, answerDTO);
        return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AnswerResponseDTO> deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
