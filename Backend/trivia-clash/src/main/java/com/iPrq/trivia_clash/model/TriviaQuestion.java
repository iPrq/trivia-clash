package com.iPrq.trivia_clash.model;

import lombok.Data;

import java.util.List;

@Data
public class TriviaQuestion {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;

}
