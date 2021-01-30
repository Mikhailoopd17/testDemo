package com.example.demo.pojo.messages;

import com.example.demo.base.BaseParams;

import java.time.LocalDate;

public class MessageParams extends BaseParams {
    private LocalDate end = LocalDate.now();

    @Override
    public LocalDate getEnd() {
        return end;
    }

    @Override
    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
