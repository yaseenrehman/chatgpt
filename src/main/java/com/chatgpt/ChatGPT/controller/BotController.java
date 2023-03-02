package com.chatgpt.ChatGPT.controller;

import com.chatgpt.ChatGPT.model.BotRequest;
import com.chatgpt.ChatGPT.model.ChatGptResponse;
import com.chatgpt.ChatGPT.service.BotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/bot")
@RequiredArgsConstructor
public class BotController {

    private final BotService botService;

    @PostMapping(value = "/send")
    public ChatGptResponse sendMessage(@RequestBody BotRequest botRequest) {
        return botService.askQuestion(botRequest);
    }

}
