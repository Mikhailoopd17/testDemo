package com.example.demo.pojo.messages;


public class MessageRequestDTO {
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

    public Message toMessage() {
        Message message = new Message();
        message.setText(this.text);
        return message;
    }
}
