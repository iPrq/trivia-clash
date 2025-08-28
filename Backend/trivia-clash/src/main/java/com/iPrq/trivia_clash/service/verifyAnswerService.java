package com.iPrq.trivia_clash.service;

import com.iPrq.trivia_clash.model.AnswerPayload;
import com.iPrq.trivia_clash.model.ScoreResponse;
import org.springframework.stereotype.Service;

@Service
public class verifyAnswerService {
    private final GameSession gameSession;
    private final ScoreManager scoreManager;

    public verifyAnswerService(GameSession gameSession, ScoreManager scoreManager) {
        this.gameSession = gameSession;
        this.scoreManager = scoreManager;
    }

    public ScoreResponse verify(AnswerPayload payload) {
       if(gameSession.getCurrentQuestion().getCorrect_answer().equals(payload.getAnswer())) {
              scoreManager.addScore(payload.getUsername(), 10);
              return new ScoreResponse(payload.getUsername(), payload.getAnswer(), true, 10);
         }
       else {
              scoreManager.addScore(payload.getUsername(), 0);
              return  new ScoreResponse(payload.getUsername(), payload.getAnswer(), false, 0);
       }
    }
}
