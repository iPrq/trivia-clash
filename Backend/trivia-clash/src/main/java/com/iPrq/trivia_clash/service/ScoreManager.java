package com.iPrq.trivia_clash.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class ScoreManager {
    private final Map<String, Integer> userScores = new ConcurrentHashMap<>();

    public void addScore(String username, int points) {
        userScores.merge(username, points, Integer::sum);
    }
        public Map<String, Integer> getAllScores() {
            return new ConcurrentHashMap<>(userScores);
        }


    public void resetAllScores() {
        userScores.replaceAll((k, v) -> 0);
    }
}
