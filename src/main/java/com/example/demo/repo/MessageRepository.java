package com.example.demo.repo;

import com.example.demo.pojo.messages.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findMessageById(Long id);


    List<Message> findAllByCreatedAtBetweenAndDeletedIsOrderById(LocalDateTime createdAtStart, LocalDateTime createdAtEnd, Boolean isDeleted);
}
