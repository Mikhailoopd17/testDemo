package com.example.demo.pojo.messages;

import com.example.demo.base.BaseParams;
import java.time.LocalDate;

public class MessageParams extends BaseParams {
    private LocalDate start = LocalDate.now().minusMonths(1);
    private LocalDate end = LocalDate.now().plusDays(1);

    @Override
    public LocalDate getStart() {
        return start;
    }

    @Override
    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Override
    public LocalDate getEnd() {
        return end;
    }

    @Override
    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
