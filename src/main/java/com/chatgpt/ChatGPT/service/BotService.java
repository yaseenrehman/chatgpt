package com.chatgpt.ChatGPT.service;

import com.chatgpt.ChatGPT.model.BotRequest;
import com.chatgpt.ChatGPT.model.ChatGptResponse;

public interface BotService {

    ChatGptResponse askQuestion(BotRequest botRequest);

}
