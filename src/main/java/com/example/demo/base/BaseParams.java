package com.example.demo.base;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.List;

@MappedSuperclass
public abstract class BaseParams {
    private List<Long> ids;
    private LocalDate start;
    private LocalDate end;
    private Boolean isDeleted = Boolean.FALSE;
    private String searchText;
    private List<Long> senderIds;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<Long> getSenderIds() {
        return senderIds;
    }

    public void setSenderIds(List<Long> senderIds) {
        this.senderIds = senderIds;
    }
}
