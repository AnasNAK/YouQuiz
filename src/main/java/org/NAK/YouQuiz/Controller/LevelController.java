package org.NAK.YouQuiz.Controller;

import jakarta.validation.Valid;
import org.NAK.YouQuiz.DTO.Level.LevelDTO;
import org.NAK.YouQuiz.DTO.Level.LevelResponseDTO;
import org.NAK.YouQuiz.DTO.Level.LevelResponseSharedDTO;
import org.NAK.YouQuiz.Service.Contract.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
public class LevelController {

    private final LevelService levelService;
    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping
    public ResponseEntity<LevelResponseSharedDTO> createLevel(@Valid @RequestBody LevelDTO levelDTO) {
        LevelResponseSharedDTO level = levelService.createLevel(levelDTO);
        return new ResponseEntity<>(level, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelResponseDTO> getLevel(@PathVariable Long id) {
        LevelResponseDTO level = levelService.getLevel(id);
        return new ResponseEntity<>(level, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<LevelResponseDTO>> getLevels() {
        List<LevelResponseDTO> levels = levelService.getLevels();
        return new ResponseEntity<>(levels, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<LevelResponseDTO> updateLevel(@PathVariable Long id,@Valid @RequestBody LevelDTO levelDTO) {
        LevelResponseDTO level = levelService.updateLevel(id, levelDTO);
        return new ResponseEntity<>(level, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLevel(@PathVariable Long id) {
        levelService.deleteLevel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
