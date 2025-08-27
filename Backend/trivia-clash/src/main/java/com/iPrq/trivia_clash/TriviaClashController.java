package com.iPrq.trivia_clash;

import com.iPrq.trivia_clash.model.QuestionDTO;
import com.iPrq.trivia_clash.service.getQuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quiz")
public class TriviaClashController {
    private final getQuestionService getQuestionService;
    public TriviaClashController(getQuestionService getQuestionService) {
        this.getQuestionService = getQuestionService;
    }
    @GetMapping("/get")

    public QuestionDTO getQuestion( @RequestParam(value = "difficulty", required = false, defaultValue = "easy") String difficulty,
                                    @RequestParam(value = "category", required = false, defaultValue = "9") String category) {
        return getQuestionService.execute(difficulty,category);

    }

}
