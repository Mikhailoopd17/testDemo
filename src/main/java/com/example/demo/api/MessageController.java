package com.example.demo.api;

import com.example.demo.base.BaseController;
import com.example.demo.base.BaseService;
import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.messages.MessageParams;
import com.example.demo.pojo.messages.MessageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "${web.prefix}/messages", produces = "application/json; charset=UTF-8")
public class MessageController extends BaseController<MessageResponseDto, MessageParams, Message> {

    @Autowired
    public MessageController(BaseService<MessageResponseDto, MessageParams, Message> baseService) {
        super(baseService);
    }
}
