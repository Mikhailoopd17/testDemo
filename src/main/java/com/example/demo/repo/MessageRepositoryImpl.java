package com.example.demo.repo;

import com.example.demo.base.BaseDao;
import com.example.demo.pojo.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements BaseDao<Message> {
    private MessageRepository messageRepository;

    @Autowired
    public MessageRepositoryImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message create(Message entity) {
        return messageRepository.save(entity);
    }

    @Override
    public Message getById(Long id) {
        return messageRepository.findMessageById(id);
    }

    @Override
    public Message update(Message entity) {
        return messageRepository.save(entity);
    }

    @Override
    public List<Message> list(LocalDateTime start, LocalDateTime end, Boolean isDeleted) {
        return messageRepository.findAllByCreatedAtBetweenAndDeletedIsOrderById(start, end, isDeleted);

    }
}
