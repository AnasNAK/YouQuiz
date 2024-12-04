package org.NAK.YouQuiz.Service.Implementation;

import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionDTO;
import org.NAK.YouQuiz.DTO.AnswerQuestion.AnswerQuestionResponseDTO;
import org.NAK.YouQuiz.Entity.Answer;
import org.NAK.YouQuiz.Entity.AnswerQuestion;
import org.NAK.YouQuiz.Entity.Level;
import org.NAK.YouQuiz.Entity.Question;
import org.NAK.YouQuiz.Exception.MaxAnswerQuestion;
import org.NAK.YouQuiz.Exception.MaxCorrectAnswer;
import org.NAK.YouQuiz.Exception.MaxWrongAnswers;
import org.NAK.YouQuiz.Exception.PointsException;
import org.NAK.YouQuiz.Mapper.AnswerQuestionMapper;
import org.NAK.YouQuiz.Repository.AnswerQuestionRepository;
import org.NAK.YouQuiz.Service.Contract.AnswerService;
import org.NAK.YouQuiz.Service.Contract.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnswerQuestionServiceImplTest {

    @InjectMocks
    private AnswerQuestionServiceImpl answerQuestionService;

    @Mock
    private AnswerQuestionRepository answerQuestionRepository;

    @Mock
    private AnswerQuestionMapper answerQuestionMapper;

    @Mock
    private AnswerService answerService;

    @Mock
    private QuestionService questionService;

    private Question question;
    private Answer answer;
    private Level level;
    private AnswerQuestionDTO answerQuestionDTO;

    @BeforeEach
    void setUp() {
        level = new Level();
        level.setMinPoints(5);
        level.setMaxPoints(10);

        question = new Question();
        question.setId(1L);
        question.setAnswers(3);
        question.setCorrectAnswers(2);
        question.setLevel(level);

        answer = new Answer();
        answer.setId(1L);

        answerQuestionDTO = new AnswerQuestionDTO();
        answerQuestionDTO.setQuestionId(1L);
        answerQuestionDTO.setAnswerId(1L);
        answerQuestionDTO.setPoint(6.0);
    }

    private Question createQuestionWithMaxAnswers() {
        Question question = new Question();
        question.setId(1L);
        question.setAnswers(3);
        question.setCorrectAnswers(2);
        question.setLevel(level);
        return question;
    }
    private Question createValidQuestion() {
        Question question = new Question();
        question.setId(1L);
        question.setQuestionDesc("test description");
        question.setLevel((level));
        question.setAnswers(5);
        question.setCorrectAnswers(2);
        return question;
    }

    private Answer createValidAnswer() {
        Answer answer = new Answer();
        answer.setId(1L);
        answer.setAnswer("Valid Answer Text");
        return answer;
    }

    @Test
    void createAnswerQuestion_MaxCorrectAnswersExceeded() {
        Question validQuestion = createValidQuestion();
        validQuestion.setCorrectAnswers(1);
        validQuestion.setAnswerQuestions(new ArrayList<>());

        when(questionService.getQuestionEntityByID(1L)).thenReturn(validQuestion);
        when(answerService.getAnswerEntityById(1L)).thenReturn(createValidAnswer());

        AnswerQuestionDTO answerQuestionDTO = new AnswerQuestionDTO();
        answerQuestionDTO.setQuestionId(1L);
        answerQuestionDTO.setAnswerId(1L);
        answerQuestionDTO.setPoint(6);

        AnswerQuestion existingCorrectAnswer = new AnswerQuestion();
        existingCorrectAnswer.setPoint(6);
        validQuestion.getAnswerQuestions().add(existingCorrectAnswer);

        MaxCorrectAnswer thrown = assertThrows(MaxCorrectAnswer.class, () -> {
            answerQuestionService.createAnswerQuestion(answerQuestionDTO);
        });

        assertEquals("you can't add more than 1correct answers for the questionId1", thrown.getMessage());
    }


    @Test
    void createAnswerQuestion_ExceedingWrongAnswers() {
        Question questionWithWrongAnswers = createQuestionWithMaxAnswers();
        questionWithWrongAnswers.setAnswers(5);
        questionWithWrongAnswers.setCorrectAnswers(2);
        questionWithWrongAnswers.getAnswerQuestions().addAll(List.of(new AnswerQuestion(), new AnswerQuestion(), new AnswerQuestion())); // Adding 3 wrong answers

        when(questionService.getQuestionEntityByID(1L)).thenReturn(questionWithWrongAnswers);

        AnswerQuestionDTO answerQuestionDTO = new AnswerQuestionDTO();
        answerQuestionDTO.setQuestionId(1L);
        answerQuestionDTO.setAnswerId(1L);
        answerQuestionDTO.setPoint(0);

        MaxWrongAnswers exception = assertThrows(
                MaxWrongAnswers.class,
                () -> answerQuestionService.createAnswerQuestion(answerQuestionDTO)
        );

        String expectedMessage = "you cannot add more than 3 false answers to questionId : 1";
        assertEquals(expectedMessage, exception.getMessage());
    }


    @Test
    void createAnswerQuestion_ValidInput() {
        Question validQuestion = createValidQuestion();
        Answer validAnswer = createValidAnswer();

        when(questionService.getQuestionEntityByID(1L)).thenReturn(validQuestion);
        when(answerService.getAnswerEntityById(1L)).thenReturn(validAnswer);

        AnswerQuestionDTO answerQuestionDTO = new AnswerQuestionDTO();
        answerQuestionDTO.setQuestionId(1L);
        answerQuestionDTO.setAnswerId(1L);
        answerQuestionDTO.setPoint(6);

        AnswerQuestion savedAnswerQuestion = new AnswerQuestion();
        when(answerQuestionMapper.toAnswerQuestion(answerQuestionDTO)).thenReturn(savedAnswerQuestion);
        when(answerQuestionRepository.save(savedAnswerQuestion)).thenReturn(savedAnswerQuestion);
        when(answerQuestionMapper.toAnswerQuestionResponseDTO(savedAnswerQuestion)).thenReturn(new AnswerQuestionResponseDTO());

        AnswerQuestionResponseDTO response = answerQuestionService.createAnswerQuestion(answerQuestionDTO);

        assertNotNull(response);

        verify(answerQuestionMapper, times(1)).toAnswerQuestion(answerQuestionDTO);
        verify(answerQuestionRepository, times(1)).save(savedAnswerQuestion);
        verify(answerQuestionMapper, times(1)).toAnswerQuestionResponseDTO(savedAnswerQuestion);
    }




    @Test
    void createAnswerQuestion_PointsOutOfRange() {
        answerQuestionDTO.setPoint(15.0);

        double minPoint = level.getMinPoints();
        double maxPoint = level.getMaxPoints();

        when(questionService.getQuestionEntityByID(1L)).thenReturn(question);

        PointsException exception = assertThrows(
                PointsException.class,
                () -> answerQuestionService.createAnswerQuestion(answerQuestionDTO)
        );

        String expectedMessage = String.format(
                "this answer cannot have on point %.1f because the min point of this question is %.1f and the max point of this question is %.1f",
                15.0, minPoint, maxPoint
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void createAnswerQuestion_MaxTotalAnswersExceeded() {
        Question questionWithTooManyAnswers = createQuestionWithMaxAnswers();
        questionWithTooManyAnswers.getAnswerQuestions().addAll(List.of(new AnswerQuestion(), new AnswerQuestion(), new AnswerQuestion())); // 3 total answers

        when(questionService.getQuestionEntityByID(1L)).thenReturn(questionWithTooManyAnswers);

        MaxAnswerQuestion exception = assertThrows(
                MaxAnswerQuestion.class,
                () -> answerQuestionService.createAnswerQuestion(answerQuestionDTO)
        );

        String expectedMessage = "this question can have just 3 answers not more";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}
