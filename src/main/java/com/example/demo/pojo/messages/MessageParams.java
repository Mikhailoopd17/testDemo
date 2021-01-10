package com.example.demo.pojo.messages;

import com.example.demo.pojo.senders.Sender;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class MessageParams {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime created_at;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updated_at;
    private String text;
    private Sender sender;
}
