package com.example.demo.base;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<T extends AEntry, R extends CommonRepository<T>> implements CommonService<T> {
    private final R repository;

    @Autowired
    public BaseService(R repository) {
        this.repository = repository;
    }
}
