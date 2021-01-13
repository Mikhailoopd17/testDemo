package com.example.demo.pojo;

import com.example.demo.base.BaseParams;

import java.io.Serializable;

public class PageParams<T extends BaseParams> implements Serializable {
    private Integer start;
    private Integer page;
    private T params;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
