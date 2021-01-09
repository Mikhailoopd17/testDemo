package com.example.demo.base;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommonService<T extends AEntry>{
    @Query("select '*' from T where id = :id and deleted_at is null")
    T getById(@Param("id") Long id);

    List<T> findAll();
}
