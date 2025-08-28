package com.iPrq.trivia_clash;

import com.iPrq.trivia_clash.model.QuestionDTO;

import com.iPrq.trivia_clash.service.ScoreManager;
import com.iPrq.trivia_clash.service.getQuestionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quiz")
public class TriviaClashController {
    private final getQuestionService getQuestionService;
    private final ScoreManager scoreManager;
    public TriviaClashController(getQuestionService getQuestionService, ScoreManager scoreManager) {
        this.getQuestionService = getQuestionService;
        this.scoreManager = scoreManager;
    }
    @GetMapping("/get")
    public QuestionDTO getQuestion( @RequestParam(value = "difficulty", required = false, defaultValue = "easy") String difficulty,
                                    @RequestParam(value = "category", required = false, defaultValue = "9") String category) {
        return getQuestionService.execute(difficulty,category);

    }

    @GetMapping("/score")
    public Map<String, Integer> getScore() {
        return scoreManager.getAllScores();
    }

    @DeleteMapping("/reset")
    public ResponseEntity<Void> resetScore() {
        scoreManager.resetAllScores();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }





}
