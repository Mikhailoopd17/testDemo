package com.example.demo.service;

import com.example.demo.pojo.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface SenderRepository extends JpaRepository<Sender, Long> {
}
