package com.example.demo.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public abstract class AbstractController<T extends AEntry, S extends CommonService<T>> implements CommonController<T> {
    private final S service;

    @Autowired
    public AbstractController(S service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/all")
    public List<T> findAll() {
        return service.findAll();
    }
}
