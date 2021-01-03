package com.example.demo.pojo.senders;

import com.example.demo.pojo.AEntry;
import com.example.demo.pojo.messages.Message;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="senders")
public class Sender extends AEntry {
    private String name;
    private List<Message> messages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
