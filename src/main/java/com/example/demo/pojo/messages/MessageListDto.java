package com.example.demo.pojo.messages;

import com.example.demo.pojo.senders.SenderDto;

import java.time.LocalDateTime;

public class MessageListDto {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String text;
    private SenderDto senderDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
