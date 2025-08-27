package com.iPrq.trivia_clash.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private int response_code;
    private List<TriviaQuestion> results;

}
