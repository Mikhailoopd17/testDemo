package com.example.demo.repo;

import com.example.demo.Exception.UserExceptions;
import com.example.demo.base.BaseDao;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.PageParams;
import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.messages.MessageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MessageRepositoryImpl implements BaseDao<Message, MessageParams> {
    @Value("${last.messages.limit:20}")
    private Integer limitLastMessages;

    private MessageRepository messageRepository;

    private UserRepository userRepository;

    @Autowired
    public MessageRepositoryImpl(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Message create(Message entity) {
        if (entity.getSender() == null || !userRepository.existsById(entity.getSenderId()) ) {
            throw new UserExceptions.RestException("Отправитель сообщения не задан или не существует!");
        }
        if (entity.getText() == null || entity.getText().trim().length() > 0) {
            throw new UserExceptions.RestException("Сообщение не должно быть пустым!");
        }
        return messageRepository.save(entity);
    }

    @Override
    public Message getById(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new UserExceptions.RestException("Невозможно найти сообщение с id: "+ id);
        }
        return messageRepository.findMessageById(id);
    }

    @Override
    public Message update(Message entity) {
        if (entity.getId() == null || !messageRepository.existsById(entity.getId())) {
            throw new UserExceptions.RestException("Невозможно обновить сообщение c id: "+ entity.getId());
        }
        if (entity.getText() == null || entity.getText().trim().length() > 0) {
            throw new UserExceptions.RestException("Сообщение не должно быть пустым!");
        }
        Message message = messageRepository.findMessageById(entity.getId());
        message.setUpdatedAt(LocalDateTime.now());
        message.setText(entity.getText());
        return messageRepository.save(entity);
    }

    @Override
    public Page<Message> list(PageParams<MessageParams> pageParams) {
        final MessageParams messageParams = pageParams.getParams() == null ? new MessageParams() : pageParams.getParams();
        List<Message> messages;
        if (messageParams.getStart() == null) {
            messages = messageRepository.findLimitMessages(limitLastMessages);
        } else {
            messages = messageRepository.findAllByCreatedAtBetweenAndDeletedIsOrderById(messageParams.getStart().atStartOfDay(),
                    messageParams.getEnd().plusDays(1).atStartOfDay(), messageParams.getDeleted());
        }


        if (pageParams.getParams().getSearchText() != null) {
            messages = messages.stream().filter(message -> message.getText().toLowerCase().contains(pageParams.getParams().getSearchText())).collect(Collectors.toList());
        }

//        if (params.getIds() != null) {
//            messages = messages.stream().filter(message -> params.getIds().contains(message.getId())).collect(Collectors.toList());
//        }
//        if (params.getSenderIds() != null) {
//            messages = messages.stream().filter(message -> params.getSenderIds().contains(message.getSender().getId())).collect(Collectors.toList());
//        }

        return new Page<>(messages, (long) messages.size());
    }
}
