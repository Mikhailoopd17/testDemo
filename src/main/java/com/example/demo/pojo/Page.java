package com.example.demo.pojo;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    private List<T> list;
    private Long total;

    public Page(List<T> list, Long total) {
        this.list = list;
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
