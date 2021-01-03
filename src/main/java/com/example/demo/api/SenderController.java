package com.example.demo.api;

import com.example.demo.pojo.senders.Sender;
import com.example.demo.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${web.prefix}/senders", produces = "application/json; charset=UTF-8")
public class SenderController {

    @Autowired
    private SenderService senderService;

    @PostMapping
    public Sender addSender(@RequestBody Sender sender) {
        senderService.addSender(sender);
        return sender;
    }

    @GetMapping
    public List<Sender> getAllSenders() {
        return senderService.getAll();
    }
}
