package com.hibernatelearn;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Questions {

    @Id
    private int question_id;
    private String question;

    @OneToOne 
    @JoinColumn (name="a_id")
    private Answer answer;

    public Questions(int question_id, String question) {
        this.question_id = question_id;
        this.question = question;
    }

    public Questions() {
        super();
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> l1) {
        this.answer = (Answer) l1;
    }

    @Override
    public String toString() {
        return "Questions [question_id=" + question_id + ", question=" + question + ", answer=" + answer + "]";
    }

}
