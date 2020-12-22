package com.example.demo.pojo;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message extends AEntry {
    private String text;

    private Sender sender;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id")
    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public MessageResponse fromMessage() {
        MessageResponse response = new MessageResponse();
        response.setId(this.getId());
        response.setCreated_at(this.getCreated_at());
        response.setText(this.getText());
        response.setSender_id(this.getSender().getId());
        return response;
    }
}
