package org.NAK.YouQuiz.Service.Implementation;

import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseDTO;
import org.NAK.YouQuiz.Entity.Answer;
import org.NAK.YouQuiz.Entity.AnswerQuestion;
import org.NAK.YouQuiz.Entity.Embedded.AnswerQuestionKey;
import org.NAK.YouQuiz.Entity.Question;
import org.NAK.YouQuiz.Exception.MaxAnswerQuestion;
import org.NAK.YouQuiz.Exception.MaxCorrectAnswer;
import org.NAK.YouQuiz.Exception.MaxWrongAnswers;
import org.NAK.YouQuiz.Exception.PointsException;
import org.NAK.YouQuiz.Mapper.AnswerQuestionMapper;
import org.NAK.YouQuiz.Repository.AnswerQuestionRepository;
import org.NAK.YouQuiz.Service.Contract.AnswerQuestionService;
import org.NAK.YouQuiz.Service.Contract.AnswerService;
import org.NAK.YouQuiz.Service.Contract.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnswerQuestionServiceImpl implements AnswerQuestionService {

    private final AnswerQuestionRepository answerQuestionRepository;

    private final AnswerQuestionMapper answerQuestionMapper;

    private final AnswerService answerService;

    private final QuestionService questionService;

    @Override
    public AnswerQuestionResponseDTO createAnswerQuestion(AnswerQuestionDTO answerQuestionDTO) {

        Question existedQuestion = questionService.getQuestionEntityByID(answerQuestionDTO.getQuestionId());

        Answer existedAnswer = answerService.getAnswerEntityById(answerQuestionDTO.getAnswerId());

        double minPoint = existedQuestion.getLevel().getMinPoints();

        double maxPoint = existedQuestion.getLevel().getMaxPoints();

        int wrongAnswers = existedQuestion.getAnswers() - existedQuestion.getCorrectAnswers();

        int countWrongAnswers = (int) existedQuestion.getAnswerQuestions()
                .stream()
                .filter(answerQuestion -> answerQuestion.getPoint() == 0)
                .count();


        if (answerQuestionDTO.getPoint() == 0) {

            if (countWrongAnswers >= wrongAnswers) {
                throw new MaxWrongAnswers(existedQuestion.getId(), wrongAnswers);
            }
            AnswerQuestion savedAnswerQuestion = answerQuestionMapper.toAnswerQuestion(answerQuestionDTO);

            AnswerQuestion created = answerQuestionRepository.save(savedAnswerQuestion);

            return answerQuestionMapper.toAnswerQuestionResponseDTO(created);

        }

        if (answerQuestionDTO.getPoint() <= minPoint || answerQuestionDTO.getPoint() >= maxPoint) {

            throw new PointsException(answerQuestionDTO.getPoint(), maxPoint, minPoint);

        }

        int totalAnswers = existedQuestion.getAnswerQuestions().size();
        if (totalAnswers >= existedQuestion.getAnswers()) {
            throw new MaxAnswerQuestion(existedQuestion.getAnswers());
        }

        int correctAnswers = (int) existedQuestion.getAnswerQuestions()
                .stream()
                .filter(answerQuestion -> answerQuestion.getPoint() > 0)
                .count();

        if (correctAnswers >= existedQuestion.getCorrectAnswers()) {
            throw new MaxCorrectAnswer(existedQuestion.getId(), existedQuestion.getCorrectAnswers());
        }


        AnswerQuestion savedAnswerQuestion = answerQuestionMapper.toAnswerQuestion(answerQuestionDTO);

        AnswerQuestion created = answerQuestionRepository.save(savedAnswerQuestion);

        return answerQuestionMapper.toAnswerQuestionResponseDTO(created);

    }

    @Override
    public AnswerQuestionResponseDTO updateAnswerQuestion(AnswerQuestionDTO answerQuestionDTO) {

        AnswerQuestionKey answerQuestionKey = new AnswerQuestionKey(
                answerQuestionDTO.getAnswerId(),
                answerQuestionDTO.getQuestionId());

        AnswerQuestion existedAnswerQuestion = answerQuestionRepository.findByAnswerIdAndQuestionId(answerQuestionKey.getAnswerId(), answerQuestionKey.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Answer Question Not Found with answer id " + answerQuestionKey.getAnswerId() + " and question id " + answerQuestionKey.getQuestionId()));


        AnswerQuestion updatedAnswerQuestion = answerQuestionMapper.toAnswerQuestion(answerQuestionDTO);

        answerQuestionRepository.save(updatedAnswerQuestion);

        return answerQuestionMapper.toAnswerQuestionResponseDTO(updatedAnswerQuestion);
    }

    @Override
    public void deleteAnswerQuestion(AnswerQuestionKey answerQuestionKey) {

        AnswerQuestion existedAnswerQuestion = answerQuestionRepository.findByAnswerIdAndQuestionId(answerQuestionKey.getAnswerId(), answerQuestionKey.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Answer Question Not Found with answer id " + answerQuestionKey.getAnswerId() + " and question id " + answerQuestionKey.getQuestionId()));

        answerQuestionRepository.delete(existedAnswerQuestion);
    }

    @Override
    public AnswerQuestionResponseDTO getAnswerQuestion(AnswerQuestionKey answerQuestionKey) {
        AnswerQuestion existedAnswerQuestion = answerQuestionRepository.findByAnswerIdAndQuestionId(answerQuestionKey.getAnswerId(), answerQuestionKey.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Answer Question Not Found with answer id " + answerQuestionKey.getAnswerId() + " and question id " + answerQuestionKey.getQuestionId()));

        return answerQuestionMapper.toAnswerQuestionResponseDTO(existedAnswerQuestion);
    }

    @Override
    public List<AnswerQuestionResponseDTO> getAnswerQuestions() {
        return answerQuestionRepository.findAll()
                .stream()
                .map(answerQuestionMapper::toAnswerQuestionResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AnswerQuestion> findAnswerQuestion(Long answerId , Long questionId) {
        return Optional.ofNullable(answerQuestionRepository.findByAnswerIdAndQuestionId(answerId, questionId)
                .orElseThrow(() -> new RuntimeException("Answer Question Not Found with answer id " + answerId + " and question id " + questionId)));
    }
}
