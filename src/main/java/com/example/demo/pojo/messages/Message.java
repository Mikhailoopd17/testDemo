package com.example.demo.pojo.messages;

import com.example.demo.pojo.AEntry;
import com.example.demo.pojo.senders.Sender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @JsonIgnoreProperties(value = {"messages", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sender_id")
    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Boolean likeText(String substring) {
        return this.text.toLowerCase().contains(substring.toLowerCase());
    }

    public Boolean filterByCreateDate(LocalDateTime start, LocalDateTime end) {

        return (super.getCreated_at().toLocalDate().isAfter(start.toLocalDate())
                || super.getCreated_at().toLocalDate().isBefore(end.toLocalDate()));
    }
}
