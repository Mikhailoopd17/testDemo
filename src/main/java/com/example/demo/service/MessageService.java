package com.example.demo.service;

import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.messages.MessageRequest;
import com.example.demo.pojo.messages.MessageResponse;
import com.example.demo.pojo.senders.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SenderRepository senderRepository;

    public Message addMessage(MessageRequest message) {
        Message newMessage = message.toMessage();
        if (!senderRepository.existsById(message.getSenderId())) {
            throw new RuntimeException("Некорректно задан отправитель сообщения");
        }

        Sender sender = senderRepository.findById(message.getSenderId()).get();
        newMessage.setCreated_at(LocalDateTime.now());
        newMessage.setSender(sender);
        return messageRepository.save(newMessage);
    }

    public List<MessageResponse> getList() {
        return messageRepository.findAll().stream().map(Message::fromMessage).collect(Collectors.toList());
    }

    public List<Message> getAll() {
        return messageRepository.findAll();
    }
//    public static final Integer LENGHT = 50;
//
//    private String[] words = {"message ", "random ", "application ", "service ", "qwerty ", "1234 ", "empty ", "test ", "null ", " ", "10 "};
//
//    public String generateText(Integer wordNumber) {
//        StringBuilder message = new StringBuilder();
//        int i =0;
//        while (i < wordNumber) {
//            int index = (int) (Math.random() * 10);
//            message.append(words[index]);
//            i++;
//        }
//        return message.toString();
//    }
//
//    public Message getDefaultMessage(Integer wordNumber) {
//        Message message = new Message();
//        message.setText(generateText(wordNumber));
//        message.setDate(LocalDateTime.now());
//        return message;
//    }
//
//    public List<Message> getMessagesList() {
//        List<Message> list = new ArrayList<>();
//        int i = 0;
//        while((i < LENGHT)) {
//            list.add(getDefaultMessage((int) (Math.random() * 10)));
//            i++;
//        }
//        return list;
//    }
}
