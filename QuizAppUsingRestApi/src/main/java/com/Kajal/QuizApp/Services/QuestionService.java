package com.Kajal.QuizApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kajal.QuizApp.Model.Questions;
import com.Kajal.QuizApp.dao.QuestionDao;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public  List<Questions> getAllQuestions(){
          return questionDao.findAll();
    }

    public List<Questions> getQuestionByCategory(String category) {
        
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Questions question) {
        questionDao.save(question);
        return "Question added successfully";
    }


    
}
