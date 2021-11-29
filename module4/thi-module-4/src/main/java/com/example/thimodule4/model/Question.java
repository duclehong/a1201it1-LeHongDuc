package com.example.thimodule4.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 5, max = 100)
    @NotBlank(message = "title coin not blank")
    private String title;
    @Size(min = 10, max = 500)
    @NotBlank(message = "question coin not blank")
    private String question;
    private String answer   ;
    @ManyToOne
    @JoinColumn(name = "idQuestion")
    private QuestionType idQuestionType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String status;
    public Question() {
    }

    public Question(@NotBlank(message = "title coin not blank") String title, @NotBlank(message = "question coin not blank") String question, String answer, QuestionType idQuestionType, Date birthday, String status) {
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.idQuestionType = idQuestionType;
        this.birthday = birthday;
        this.status = status;
    }

    public Question(int id, @NotBlank(message = "title coin not blank") String title, @NotBlank(message = "question coin not blank") String question, String answer, QuestionType idQuestionType, Date birthday, String status) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.idQuestionType = idQuestionType;
        this.birthday = birthday;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(QuestionType idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
