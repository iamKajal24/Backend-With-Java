package com.map;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @Column(name = "Answer_Id")
    private int answerId;

    @Column(nullable = false)
    private String answer;

    // One-to-One Mapping (Commented as per your code)
    // @OneToOne(mappedBy = "answer")
    // private Question question;

    // Many-to-One Mapping
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Answer() {
        super();
    }

    public Answer(int answerId, String answer, Question question) {
        super();
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer [answerId=" + answerId + ", answer=" + answer + ", question=" + question.getQuestion() + "]";
    }
}
