package com.example.demo.repo;

import com.example.demo.pojo.messages.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findMessageById(Long id);

    @Query(value = "select * from messages where deleted_at is null", nativeQuery = true)
    List<Message> list();
}
