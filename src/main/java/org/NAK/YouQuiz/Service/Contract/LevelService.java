package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.Level.LevelDTO;
import org.NAK.YouQuiz.DTO.Level.LevelResponseDTO;
import org.NAK.YouQuiz.DTO.Level.LevelResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Level;

import java.util.List;

public interface LevelService {

    LevelResponseSharedDTO createLevel(LevelDTO levelDTO);
    LevelResponseDTO updateLevel(Long id ,LevelDTO levelDTO);
    void deleteLevel(Long id);
    LevelResponseDTO getLevel(Long id);
    List<LevelResponseDTO> getLevels();
    Level getLevelEntityById(Long id);
}
