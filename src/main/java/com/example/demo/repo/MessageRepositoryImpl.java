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

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MessageRepositoryImpl implements BaseDao<Message, MessageParams> {
    @Value("${last.messages.limit:20}")
    private Integer limitLastMessages;

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
        if (entity.getSender() == null) {
            throw new UserExceptions.RestException("Не задан отправитель");
        }
        return messageRepository.save(entity);
    }

    @Override
    public Page<Message> list(PageParams<MessageParams> pageParams) {
        final MessageParams messageParams = pageParams.getParams() == null ? new MessageParams() : pageParams.getParams();
        List<Message> messages;
        if (messageParams.getStart() == null || messageParams.getEnd() == null) {
            Integer count = messageRepository.getActiveCount();
            messages = messageRepository.findLimitMessages(count - limitLastMessages);
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
