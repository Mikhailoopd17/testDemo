package com.example.demo.service;

import com.example.demo.base.BaseService;
import com.example.demo.pojo.messages.*;
import com.example.demo.repo.MessageRepositoryImpl;
import com.example.demo.util.MappingService;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends BaseService<MessageListDto, MessageResponseDto, MessageRequestDto, MessageParams, Message> {
    public MessageService(MessageRepositoryImpl baseDao, MappingService mappingService) {
        super(baseDao, MessageResponseDto.class, Message.class, mappingService, MessageRequestDto.class, MessageListDto.class);
    }
}
