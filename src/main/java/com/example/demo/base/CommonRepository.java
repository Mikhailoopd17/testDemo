package com.example.demo.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface CommonRepository<T extends AEntry> extends JpaRepository<T, Long> {
    <T extends AEntry> T getById(Long id);

//    <T extends AEntry> List<T> findAll();
}
