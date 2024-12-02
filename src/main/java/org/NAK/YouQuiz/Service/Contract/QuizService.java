package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.Quiz.QuizDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseDTO;
import org.NAK.YouQuiz.DTO.Quiz.QuizResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Quiz;

import java.util.List;


public interface QuizService {

QuizResponseSharedDTO createQuiz(QuizDTO quizDTO);
QuizResponseDTO updateQuiz(Long id,QuizDTO quizDTO);
void deleteQuiz(Long id);
QuizResponseDTO getQuiz(Long id);
List<QuizResponseDTO> getQuizzes();
Quiz getQuizEntityById(Long id);



}
