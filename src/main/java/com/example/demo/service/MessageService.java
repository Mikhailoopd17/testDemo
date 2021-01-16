package com.example.demo.service;

import com.example.demo.base.BaseService;
import com.example.demo.pojo.messages.*;
import com.example.demo.repo.MessageRepositoryImpl;
import com.example.demo.repo.MessageRepositoryListImpl;
import com.example.demo.util.MappingService;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends BaseService<MessageListDto, MessageResponseDto, MessageRequestDto, MessageParams, Message> {
    public MessageService(MessageRepositoryImpl baseDao, MappingService mappingService, MessageRepositoryListImpl baseListDao) {
        super(baseDao, MessageResponseDto.class, Message.class, mappingService, baseListDao, MessageRequestDto.class, MessageListDto.class);
    }


//    public Message addMessage(MessageRequest message) {
//        if (!senderService.isExistSender(message.getSenderId())) {
//            throw new RuntimeException("Некорректно задан отправитель сообщения");
//        }
//
//        Message newMessage = message.toMessage();
//        Sender sender = senderService.findSenderById(message.getSenderId());
//        newMessage.setCreated_at(LocalDateTime.now());
//        newMessage.setSender(sender);
//        return messageRepository.save(newMessage);
//    }

}
