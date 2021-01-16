package com.example.demo.pojo.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageRequestDto {
    private String text;
    private Long senderId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("sender_id")
    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

}
