package com.iPrq.trivia_clash.service;

import com.iPrq.trivia_clash.model.TriviaQuestion;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class GameSession {
    private TriviaQuestion currentQuestion;

    public void setCurrentQuestion(TriviaQuestion question) {
        this.currentQuestion = question;
    }

    public TriviaQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void clear() {
        this.currentQuestion = null;
    }

}
