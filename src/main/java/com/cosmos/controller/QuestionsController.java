package com.cosmos.controller;

import com.cosmos.model.Question;
import com.cosmos.pojo.Questions;
import com.cosmos.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:help.properties")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;
    @Value("${welcomemessage}")
    private String welcomemessage;
    @GetMapping("/welcome")
    public String welcomeMessage(){
        return welcomemessage;
    }
    @PostMapping
    public Question saveQuestion(@RequestBody Question question){
        return questionsService.saveQuestion(question);
    }

    @GetMapping
    public Questions getAllQuestions(){
        return questionsService.getAllQuestions();
    }
    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable Long questionId){
        return questionsService.getQuestionById(questionId);
    }
    @DeleteMapping("/{questionId}")
    public String deleteQuestion(@PathVariable Long questionId){
        return questionsService.deleteQuestion(questionId);
    }
    @PutMapping("/{questionId}")
    public String updateQuestion(@PathVariable Long questionId, @RequestBody Question question){
        return questionsService.updateQuestion(questionId,question);
    }

}
