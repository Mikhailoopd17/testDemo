package com.example.demo.service;

import com.example.demo.pojo.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SenderService {

    private final SenderRepository repository;

    @Autowired
    public SenderService(SenderRepository repository) {
        this.repository = repository;
    }

    public Sender addSender(Sender sender) {
        repository.save(sender);
        return sender;
    }

    public List<Sender> getAll() {
        return repository.findAll();
    }
}