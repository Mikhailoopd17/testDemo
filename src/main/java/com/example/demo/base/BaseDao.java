package com.example.demo.base;


import com.example.demo.pojo.Page;
import com.example.demo.pojo.PageParams;

public interface BaseDao<T extends BaseEntity, P extends BaseParams> {
    T create(T entity);

    T getById(Long id);

    T update(T entity);

    Page<T> list(PageParams<P> params);
}
