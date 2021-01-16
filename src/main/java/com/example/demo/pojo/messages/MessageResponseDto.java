package com.example.demo.pojo.messages;

import com.example.demo.base.BaseEntity;
import com.example.demo.pojo.senders.Sender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class MessageResponseDto extends BaseEntity {
    private String text;
    private Sender sender;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonIgnoreProperties(value = {"messages", "hibernateLazyInitializer"})
    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }
}
