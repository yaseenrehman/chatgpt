package com.chatgpt.ChatGPT.service.impl;

import com.chatgpt.ChatGPT.config.ChatGptConfig;
import com.chatgpt.ChatGPT.model.BotRequest;
import com.chatgpt.ChatGPT.model.ChatGptRequest;
import com.chatgpt.ChatGPT.model.ChatGptResponse;
import com.chatgpt.ChatGPT.service.BotService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BotServiceImpl implements BotService {

    private static RestTemplate restTemplate = new RestTemplate();

    //  Build Headers
    public HttpEntity<ChatGptRequest> buildHttpEntity(ChatGptRequest chatGptRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        headers.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + ChatGptConfig.API_KEY);
        return new HttpEntity<>(chatGptRequest, headers);
    }

    //  Generate Response
    public ChatGptResponse getResponse(HttpEntity<ChatGptRequest> chatRequestHttpEntity) {
        ResponseEntity<ChatGptResponse> responseEntity = restTemplate.postForEntity(
                ChatGptConfig.URL,
                chatRequestHttpEntity,
                ChatGptResponse.class
        );
        return responseEntity.getBody();
    }

    @Override
    public ChatGptResponse askQuestion(BotRequest botRequest) {
        return this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequest(
                                ChatGptConfig.MODEL,
                                botRequest.getMessage(),
                                ChatGptConfig.TEMPERATURE,
                                ChatGptConfig.MAX_TOKEN,
                                ChatGptConfig.TOP_P
                        )
                )
        );
    }
}
