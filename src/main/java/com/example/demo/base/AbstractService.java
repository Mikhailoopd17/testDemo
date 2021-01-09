package com.example.demo.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public abstract class AbstractService<T extends AEntry, R extends CommonRepository<T>> implements CommonService<T> {

    private final R repository;

    @Autowired
    protected AbstractService(R repository) {
        this.repository = repository;
    }

    public T getById(Long id) {
        return repository.getById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }
}
