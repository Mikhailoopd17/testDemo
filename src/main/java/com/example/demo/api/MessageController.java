package com.example.demo.api;

import com.example.demo.pojo.Message;
import com.example.demo.pojo.MessageResponse;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${web.prefix}/messages", produces = "application/json; charset=UTF-8")
public class MessageController {

    @Autowired
    public MessageService messageService;

    @GetMapping
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @GetMapping("/list")
    public List<MessageResponse> getList() {
        return messageService.getList();
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        return messageService.addMessage(message);
    }
//

}
