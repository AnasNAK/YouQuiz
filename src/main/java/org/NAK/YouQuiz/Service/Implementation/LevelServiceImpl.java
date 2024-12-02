package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.Level.LevelDTO;
import org.NAK.YouQuiz.DTO.Level.LevelResponseDTO;
import org.NAK.YouQuiz.DTO.Level.LevelResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Level;
import org.NAK.YouQuiz.Mapper.LevelMapper;
import org.NAK.YouQuiz.Repository.LevelRepository;
import org.NAK.YouQuiz.Service.Contract.LevelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    private final LevelMapper levelMapper;

    @Override
    public LevelResponseSharedDTO createLevel(LevelDTO levelDTO) {
        Level level = levelMapper.toLevel(levelDTO);
       Level savedlevel = levelRepository.save(level);
        return levelMapper.toLevelResponseSharedDTO(savedlevel);
    }

    @Override
    public LevelResponseDTO updateLevel(Long id ,LevelDTO levelDTO) {

        Level existedLevel = levelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("level with id " + id + " not found"));

        Level updatedLevel = levelMapper.toLevel(levelDTO);
        updatedLevel.setId(id);
        levelRepository.save(updatedLevel);

        return levelMapper.toLevelResponseDTO(existedLevel);
    }

    @Override
    public void deleteLevel(Long id) {
        if (!levelRepository.existsById(id)) {
            throw new EntityNotFoundException("level with id " + id + " not found");
        }

        levelRepository.deleteById(id);
    }

    @Override
    public LevelResponseDTO getLevel(Long id) {
        return levelRepository.findById(id)
                .map(levelMapper::toLevelResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("level with id " + id + " not found"));
    }

    @Override
    public List<LevelResponseDTO> getLevels() {
        return levelRepository.findAll()
                .stream()
                .map(levelMapper::toLevelResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Level getLevelEntityById(Long id) {
        return levelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("level with id " + id + " not found"));
    }
}
