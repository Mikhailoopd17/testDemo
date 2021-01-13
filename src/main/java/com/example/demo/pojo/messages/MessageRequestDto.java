package com.example.demo.pojo.messages;

public class MessageRequestDto {
    private String text;
    private Long senderId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

}
