package com.example.demo.base;


import com.example.demo.pojo.AEntry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface BaseDao<T extends AEntry> {
    T create(T entity);

    T getById(Long id);

    T update(T entity);

    List<T> list(LocalDateTime start, LocalDateTime end, Boolean isDeleted);
}
