package org.NAK.YouQuiz.Controller;

import jakarta.validation.Valid;
import org.NAK.YouQuiz.DTO.Subject.SubjectDTO;
import org.NAK.YouQuiz.DTO.Subject.SubjectResponseDTO;
import org.NAK.YouQuiz.DTO.Subject.SubjectResponseSharedDTO;
import org.NAK.YouQuiz.Service.Contract.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<SubjectResponseSharedDTO> createSubject(@Valid @RequestBody SubjectDTO subjectDTO){
        SubjectResponseSharedDTO subjectResponseSharedDTO = subjectService.createSubject(subjectDTO);
        return ResponseEntity.ok(subjectResponseSharedDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> getSubject(@PathVariable Long id){
        SubjectResponseDTO subject = subjectService.getSubject(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SubjectResponseDTO>> getAllSubjects(){
        List<SubjectResponseDTO> subjects = subjectService.getSubjects();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> updateSubject(@PathVariable Long id,@Valid @RequestBody SubjectDTO subjectDTO){
        SubjectResponseDTO subjectResponseDTO = subjectService.updateSubject(id, subjectDTO);
        return new ResponseEntity<>(subjectResponseDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
