package com.example.demo.service;

import com.example.demo.base.BaseService;
import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.messages.MessageParams;
import com.example.demo.pojo.messages.MessageResponseDto;
import com.example.demo.repo.MessageRepositoryImpl;
import com.example.demo.util.MappingService;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends BaseService<MessageResponseDto, MessageParams, Message> {
    public MessageService(MessageRepositoryImpl baseDao, MappingService mappingService) {
        super(baseDao, MessageResponseDto.class, Message.class, mappingService);
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
