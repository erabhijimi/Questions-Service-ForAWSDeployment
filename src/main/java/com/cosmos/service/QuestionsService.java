package com.cosmos.service;

import com.cosmos.model.Question;
import com.cosmos.pojo.Questions;
import com.cosmos.repository.QuestionsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;
    public Questions getAllQuestions() {
        List<Question> questionList = questionsRepository.findAll();
        Questions questions = new Questions();
        questions.setQuestions(questionList);
        return questions;
    }

    public Question saveQuestion(Question question) {
        return questionsRepository.save(question);
    }

    public Question getQuestionById(Long questionId) {
        Optional<Question> optionalQuestion = questionsRepository.findById(questionId);
        if(!optionalQuestion.isPresent())
            return new Question();
        return optionalQuestion.get();
    }

    public String deleteQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionsRepository.findById(questionId);
        if(!optionalQuestion.isPresent()){
            return "Question is not available..";
        }
        log.info("New Delete request for Question"+questionId);
        questionsRepository.delete(optionalQuestion.get());
        return "Question Deleted Successfully...";

    }

    public String updateQuestion(Long questionId, Question question) {
        Optional<Question> optionalQuestion = questionsRepository.findById(questionId);
        if(!optionalQuestion.isPresent()){
            return "Question is not available..";
        }
        log.info("New Update request for Question"+question.toString());
        question.setQuestionId(questionId);
        questionsRepository.save(question);
        return "Question Updated Successfully...";
    }
}
