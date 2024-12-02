package org.NAK.YouQuiz.Controller;

import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseDTO;
import org.NAK.YouQuiz.DTO.AnswerValidation.AnswerValidationResponseSharedDTO;
import org.NAK.YouQuiz.Service.Contract.AnswerValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answerValidations")
public class AnswerValidationController {

    private final AnswerValidationService answerValidationService;

    public AnswerValidationController(AnswerValidationService answerValidationService) {
        this.answerValidationService = answerValidationService;
    }

    @PostMapping
    public ResponseEntity<AnswerValidationResponseSharedDTO> createAnswerValidation(@RequestBody AnswerValidationDTO answerValidationDTO ) {
        AnswerValidationResponseSharedDTO answerValidation = answerValidationService.createAnswerValidation(answerValidationDTO);
        return new ResponseEntity<>(answerValidation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerValidationResponseDTO> getAnswerValidationById(@PathVariable Long id) {
        AnswerValidationResponseDTO answerValidation = answerValidationService.getAnswerValidation(id);
        return new ResponseEntity<>(answerValidation, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AnswerValidationResponseDTO>> getAllAnswerValidations() {
        List<AnswerValidationResponseDTO> answerValidations = answerValidationService.getAnswerValidations();
        return new ResponseEntity<>(answerValidations, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AnswerValidationResponseDTO> updateAnswerValidation(@PathVariable Long id, @RequestBody AnswerValidationDTO answerValidationDTO) {
        AnswerValidationResponseDTO answerValidation = answerValidationService.updateAnswerValidation(id, answerValidationDTO);
        return new ResponseEntity<>(answerValidation, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AnswerValidationResponseDTO> deleteAnswerValidation(@PathVariable Long id) {
        answerValidationService.deleteAnswerValidation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
