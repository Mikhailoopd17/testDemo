package com.example.demo.api;

import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.messages.MessageListDTO;
import com.example.demo.pojo.messages.MessageRequestDTO;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${web.prefix}/messages", produces = "application/json; charset=UTF-8")
public class MessageController {

    @Autowired
    public MessageService messageService;

//    @GetMapping
//    public List<Message> getAll(
//            @RequestParam(value = "with_user_info", required = false, defaultValue = "false") Boolean withUserInfo,
//            @RequestParam(value = "text", required = false) String text,
//            @RequestParam(value = "sender_ids", required = false) List<Long> senderIds) {
//        List<Message> messages = messageService.getFilteredList();
//        if (!withUserInfo) {
//            messages.forEach(message -> message.getSender().setUser(null));
//        }
//        return messages;
//    }

    @GetMapping("/list")
    public List<MessageListDTO> getList() {
        return messageService.getList();
    }

//    @PostMapping
//    public Message create(@RequestBody MessageRequestDTO message) {
//        return messageService.add(message);
//    }
}
