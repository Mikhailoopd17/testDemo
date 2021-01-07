package com.example.demo.api;

import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.messages.MessageRequest;
import com.example.demo.pojo.messages.MessageResponse;
import com.example.demo.service.MessageService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${web.prefix}/messages", produces = "application/json; charset=UTF-8")
public class MessageController {

    @Autowired
    public MessageService messageService;

    @GetMapping
    public List<Message> getAll(
            @RequestParam(value = "with_user_info", required = false, defaultValue = "false") Boolean withUserInfo) {
        List<Message> messages = messageService.getAll();
        if (!withUserInfo) {
            messages.forEach(message -> message.getSender().setUser(null));
        }
        return messages;
    }

    @GetMapping("/list")
    public List<MessageResponse> getList() {
        return messageService.getList();
    }

    @PostMapping
    public Message create(@RequestBody MessageRequest message) {
        return messageService.addMessage(message);
    }
//

}
