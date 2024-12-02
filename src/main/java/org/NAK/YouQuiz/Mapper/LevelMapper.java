package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.Level.LevelDTO;
import org.NAK.YouQuiz.DTO.Level.LevelResponseDTO;
import org.NAK.YouQuiz.DTO.Level.LevelResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Level;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface LevelMapper {
    Level toLevel(LevelDTO levelDTO);
    LevelResponseSharedDTO toLevelResponseSharedDTO(Level level);
    LevelResponseDTO toLevelResponseDTO(Level level);
}
