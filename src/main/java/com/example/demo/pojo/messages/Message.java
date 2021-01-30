package com.example.demo.pojo.messages;

import com.example.demo.base.BaseEntity;
import com.example.demo.pojo.senders.Sender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {
    private String text;
    private Sender sender;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonIgnoreProperties(value = {"messages", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sender_id")
    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @Transient
    public Long getSenderId() {
        return this.sender.getId();
    }
}
