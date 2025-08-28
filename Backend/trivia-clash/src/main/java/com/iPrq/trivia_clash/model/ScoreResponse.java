package com.iPrq.trivia_clash.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreResponse {
    private String username;
    private String answer;
    private boolean correct;
    private int points;
}

