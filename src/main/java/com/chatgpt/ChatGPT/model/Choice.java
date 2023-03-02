package com.chatgpt.ChatGPT.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Choice {

    private Integer index;

    private String text;

    @JsonProperty("finish_reason")
    private String finishReason;

}
