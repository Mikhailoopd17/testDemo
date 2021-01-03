package com.example.demo.service;

import com.example.demo.pojo.senders.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenderRepository extends JpaRepository<Sender, Long> {
}
