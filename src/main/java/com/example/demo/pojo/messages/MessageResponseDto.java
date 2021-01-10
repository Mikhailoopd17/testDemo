package com.example.demo.pojo.messages;

import com.example.demo.pojo.AEntry;
import com.example.demo.pojo.senders.Sender;

public class MessageResponseDto extends AEntry {
    private String text;
    private Sender sender;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }
}
