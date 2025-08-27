package com.iPrq.trivia_clash.model;

import lombok.Data;

@Data
public class QuestionDTO {

    private String question;
    private String options;
    private String answer;

    public QuestionDTO(String question, String options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

}
