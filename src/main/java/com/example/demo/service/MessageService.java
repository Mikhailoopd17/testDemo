package com.example.demo.service;

import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.messages.MessageListDTO;
import com.example.demo.pojo.messages.MessageRequestDTO;
import com.example.demo.pojo.senders.Sender;
import com.example.demo.util.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SenderService senderService;

    @Autowired
    private MappingService mappingService;

//    public Message add(MessageRequestDTO message) {
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

    public List<MessageListDTO> getList() {
        return mappingService.mapList(messageRepository.findAll(), MessageListDTO.class);
    }

//    public List<Message> getFilteredList() {
//        return messageRepository.findAll();
//    }
}
