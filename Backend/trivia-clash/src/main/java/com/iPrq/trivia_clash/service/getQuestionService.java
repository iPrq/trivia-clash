package com.iPrq.trivia_clash.service;

import com.iPrq.trivia_clash.model.ApiResponse;
import com.iPrq.trivia_clash.model.QuestionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class getQuestionService {

    private final RestTemplate restTemplate;
    private final GameSession gameSession;


    public getQuestionService(RestTemplate restTemplate, GameSession gameSession) {
        this.restTemplate = restTemplate;
        this.gameSession = gameSession;
    }

    public QuestionDTO execute(String difficulty, String category) {
        String url = "https://opentdb.com/api.php?amount=1&category=" + category + "&difficulty=" + difficulty + "&type=multiple";

        ApiResponse response = restTemplate.getForObject(url, ApiResponse.class);
        if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
            var question = response.getResults().get(0);
            String options = String.join(", ", question.getIncorrect_answers()) + ", " + question.getCorrect_answer();
            gameSession.setCurrentQuestion(question);
            return new QuestionDTO(question.getQuestion(), options, question.getCorrect_answer());
        }

        return new QuestionDTO("Sample Question?", "Option1, Option2, Option3, Option4", "Option1");
    }
}
