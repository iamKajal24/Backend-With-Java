package com.map;

import java.util.List;
import javax.persistence.*;

@Entity
public class Question {

    @Id
    @Column(name = "Question_Id")
    private int questionId;

    @Column(nullable = false)
    private String question;

    // One-to-One Mapping (Commented as per your code)
    // @OneToOne
    // private Answer answer;

    // One-to-Many Mapping
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Answer> answers;

    public Question() {
        super();
    }

    public Question(int questionId, String question, List<Answer> answers) {
        super();
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    // One-to-One Getter and Setter (Commented as per your code)
    // public Answer getAnswer() {
    //     return answer;
    // }

    // public void setAnswer(Answer answer) {
    //     this.answer = answer;
    // }

    @Override
    public String toString() {
        return "Question [questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
    }
}
