package com.example.demo.pojo.messages;

import com.example.demo.pojo.senders.SenderDto;

import java.time.LocalDateTime;

public class MessageListDto {
    private Long id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String text;
    private SenderDto senderDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SenderDto getSenderDto() {
        return senderDto;
    }

    public void setSenderDto(SenderDto senderDto) {
        this.senderDto = senderDto;
    }
}
