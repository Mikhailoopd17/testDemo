package com.example.demo.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface CommonController<T extends AEntry> {
    @GetMapping("/{id}")
    T getById(@PathVariable Long id);

//    @GetMapping("/all")
//    List<T> findAll();
}
