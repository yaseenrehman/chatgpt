package com.chatgpt.ChatGPT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatGptResponse implements Serializable {

    private String id;

    private String object;

    private String model;

    private LocalDate created;

    private List<Choice> choices;

}
