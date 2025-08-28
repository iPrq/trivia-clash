package com.iPrq.trivia_clash;

import com.iPrq.trivia_clash.model.AnswerPayload;
import com.iPrq.trivia_clash.model.QuestionDTO;
import com.iPrq.trivia_clash.model.ScoreResponse;

import com.iPrq.trivia_clash.service.getQuestionService;
import com.iPrq.trivia_clash.service.verifyAnswerService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class QuizSocketController {

    private final getQuestionService getQuestionService;
    private final verifyAnswerService verifyAnswerService;

    public QuizSocketController(getQuestionService getQuestionService, verifyAnswerService verifyAnswerService) {
        this.getQuestionService = getQuestionService;
        this.verifyAnswerService = verifyAnswerService;

    }

    @MessageMapping("/start")
    @SendTo("/topic/question")
    public QuestionDTO sendQuestion(AnswerPayload payload){

        return getQuestionService.execute("easy","9");
    }

    @MessageMapping("/answer")
    @SendTo("/topic/score")
    public ScoreResponse handleAnswer(AnswerPayload payload) {
        return verifyAnswerService.verify(payload);
    }





}
