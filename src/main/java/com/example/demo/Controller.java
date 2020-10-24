package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/test")
public class Controller {

    @GetMapping
    public Message getDefaultMessage() {
        Message message = new Message();
        message.setId((int)(Math.random()*100));
        message.setName("ВОт такое сообщение");
        message.setDate(LocalDateTime.now());
        return message;
    }

    @PutMapping
    public Message getMessage(@RequestBody Message message) {
        return null;
    }

}
