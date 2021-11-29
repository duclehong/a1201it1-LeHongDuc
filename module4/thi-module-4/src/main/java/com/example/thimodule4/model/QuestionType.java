package com.example.thimodule4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table()
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuestion;
    private String name;

    @OneToMany(mappedBy = "idQuestionType")
    private List<Question> questionList;

    public QuestionType() {
    }

    public QuestionType(String name, List<Question> questionList) {
        this.name = name;
        this.questionList = questionList;
    }

    public QuestionType(int idQuestion, String name, List<Question> questionList) {
        this.idQuestion = idQuestion;
        this.name = name;
        this.questionList = questionList;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
