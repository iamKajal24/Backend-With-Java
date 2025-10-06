package com.Kajal.QuizApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Kajal.QuizApp.Model.Questions;
import com.Kajal.QuizApp.Services.QuestionService;


@RestController
@RequestMapping("/questions")
public class QuestionController {


    @Autowired
    QuestionService questionService;

    // Get all questions

    @GetMapping("/allQuestions")
    public List<Questions> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    // Get questions by category
    @GetMapping("/category/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }


    
}
