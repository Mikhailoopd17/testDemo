package com.example.demo.api;

import com.example.demo.pojo.Message;
import com.example.demo.service.MessageService;
import com.example.demo.util.MessageRequestParam;
import com.example.demo.util.MessageResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/test", produces = "application/json; charset=UTF-8")
public class Controller {

    @Autowired
    public MessageService messageService;

    @GetMapping
    public Message getDefaultMessage() {
        return messageService.getDefaultMessage(5);
    }

    @PutMapping
    public Message getMessage(@RequestBody Message message) {
        return null;
    }


    @GetMapping("/list")
    public List<Message> list() {
        return messageService.getMessagesList();
    }

    @PostMapping("/list")
    public MessageResponce list(@RequestBody MessageRequestParam param) {
        Integer pageCount, pageSize = 15, page = 1, initial = 0, last = pageSize;

        List<Message> all = messageService.getMessagesList();

        if (param.getPage() != null && param.getPage() > 0
                && param.getPerPage() != null && param.getPerPage() > 0) {
            page = param.getPage();
            pageSize = param.getPerPage();
            initial = (page - 1) * pageSize;
            last = (initial + pageSize) < all.size() ? initial + pageSize : all.size() - 1;
        }

        pageCount = all.size()/pageSize + 1;

        MessageResponce response = new MessageResponce();
        response.setMessages(all.subList(initial, last));
        response.setPage(page);
        response.setSize(pageSize);
        response.setTotalPage(pageCount);

        return response;
    }

}
