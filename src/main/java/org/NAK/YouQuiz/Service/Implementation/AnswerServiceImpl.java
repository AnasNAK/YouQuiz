package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.Answer.AnswerDTO;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseDTO;
import org.NAK.YouQuiz.DTO.Answer.AnswerResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Answer;
import org.NAK.YouQuiz.Mapper.AnswerMapper;
import org.NAK.YouQuiz.Repository.AnswerRepository;
import org.NAK.YouQuiz.Service.Contract.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @Override
    public AnswerResponseSharedDTO createAnswer(AnswerDTO answerDTO) {
        Answer answer = answerMapper.toAnswer(answerDTO);
        answerRepository.save(answer);
        return answerMapper.toAnswerResponseSharedDTO(answer);
    }

    @Override
    public AnswerResponseDTO updateAnswer(Long id ,AnswerDTO answerDTO) {
        Answer existedAnswer = answerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Answer with id:" + id + " not found"));

        Answer answer = answerMapper.toAnswer(answerDTO);
        answer.setId(id);
        answerRepository.save(answer);

        return answerMapper.toAnswerResponseDTO(answer);
    }

    @Override
    public void deleteAnswer(Long id) {
        if (!answerRepository.existsById(id)) {
            throw new EntityNotFoundException("Answer with id:" + id + " not found");

        }
        answerRepository.deleteById(id);

    }

    @Override
    public AnswerResponseDTO getAnswer(Long id) {
        return answerRepository.findById(id)
                .map(answerMapper::toAnswerResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Answer with id:" + id + " not found"));
    }

    @Override
    public List<AnswerResponseDTO> getAnswers() {
        return answerRepository.findAll()
                .stream()
                .map(answerMapper::toAnswerResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Answer getAnswerEntityById(Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer with id:" + id + " not found"));
    }
}
