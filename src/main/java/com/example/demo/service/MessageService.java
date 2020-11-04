package com.example.demo.service;

import com.example.demo.pojo.Message;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    public static final Integer LENGHT = 50;

    private String[] words = {"message ", "random ", "application ", "service ", "qwerty ", "1234 ", "empty ", "test ", "null ", " ", "10 "};

    public String generateText(Integer wordNumber) {
        StringBuilder message = new StringBuilder();
        int i =0;
        while (i < wordNumber) {
            int index = (int) (Math.random() * 10);
            message.append(words[index]);
            i++;
        }
        return message.toString();
    }

    public Message getDefaultMessage(Integer wordNumber) {
        Message message = new Message();
        message.setId((int)(Math.random()*100));
        message.setText(generateText(wordNumber));
        message.setDate(LocalDateTime.now());
        return message;
    }

    public List<Message> getMessagesList() {
        List<Message> list = new ArrayList<>();
        int i = 0;
        while((i < LENGHT)) {
            list.add(getDefaultMessage((int) (Math.random() * 10)));
            i++;
        }
        return list;
    }
}
