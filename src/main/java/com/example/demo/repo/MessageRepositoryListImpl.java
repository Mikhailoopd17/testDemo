package com.example.demo.repo;

import com.example.demo.base.BaseListDao;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.PageParams;
import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.messages.MessageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MessageRepositoryListImpl implements BaseListDao<Message, MessageParams> {
    private MessageRepository repository;

    @Autowired
    public MessageRepositoryListImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Message> list(PageParams<MessageParams> pageParams) {
        final MessageParams params = pageParams.getParams() == null ? new MessageParams() : pageParams.getParams();
        List<Message> messages = repository.list();
        if (params.getIds() != null) {
            messages = messages.stream().filter(message -> params.getIds().contains(message.getId())).collect(Collectors.toList());
        }
        if (params.getSenderIds() != null) {
            messages = messages.stream().filter(message -> params.getSenderIds().contains(message.getSender().getId())).collect(Collectors.toList());
        }
        if (params.getText() != null) {
            messages = messages.stream().filter(message -> message.likeText(params.getText())).collect(Collectors.toList());
        }
        if (params.getCreatedAtStart() != null && params.getCreatedAtEnd() != null) {
            messages = messages.stream()
                    .filter(message ->
                            message.getCreated_at()
                                    .toLocalDate()
                                    .isAfter(params.getCreatedAtStart().toLocalDate())
                            || message.getCreated_at()
                                    .toLocalDate()
                                    .isBefore(params.getCreatedAtEnd().toLocalDate())).collect(Collectors.toList());
        }
        return new Page<>(messages, (long) messages.size());
    }
}
