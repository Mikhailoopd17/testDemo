package com.example.demo.repo;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.messages.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findMessageById(Long id);

    @Query(value = "SELECT count(*) FROM (SELECT id FROM messages WHERE NOT is_deleted) as mes", nativeQuery = true)
    Integer getActiveCount();

    @Query(value = "SELECT * FROM messages WHERE NOT is_deleted offset :offset limit :limit", nativeQuery = true)
    List<Message> findLimitMessages(Integer offset, Integer limit);

    List<Message> findAllByCreatedAtBetweenAndDeletedIsOrderById(LocalDateTime createdAtStart, LocalDateTime createdAtEnd, Boolean isDeleted);
}
