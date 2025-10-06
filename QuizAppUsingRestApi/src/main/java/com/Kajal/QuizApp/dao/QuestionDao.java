package com.Kajal.QuizApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kajal.QuizApp.Model.Questions;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

   List<Questions> findByCategory(String category);
    
}
