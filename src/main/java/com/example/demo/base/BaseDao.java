package com.example.demo.base;


import java.time.LocalDateTime;
import java.util.List;

public interface BaseDao<T extends BaseEntity> {
    T create(T entity);

    T getById(Long id);

    T update(T entity);

    List<T> list(LocalDateTime start, LocalDateTime end, Boolean isDeleted);
}
