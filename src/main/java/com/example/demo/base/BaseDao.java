package com.example.demo.base;


import com.example.demo.pojo.AEntry;

import java.util.List;

public interface BaseDao<T extends AEntry> {
    T create(T entity);

    T getById(Long id);

    T update(T entity);

    List<T> list();
}
