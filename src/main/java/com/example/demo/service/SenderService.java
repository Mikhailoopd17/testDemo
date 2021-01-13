package com.example.demo.service;

import com.example.demo.pojo.senders.Sender;
import com.example.demo.pojo.senders.SenderRequest;
import com.example.demo.pojo.users.User;
import com.example.demo.repo.SenderRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class SenderService {
    private final SenderRepository senderRepository;
    private final UserRepository userRepository;

    @Autowired
    public SenderService(SenderRepository senderRepository, UserRepository userRepository) {
        this.senderRepository = senderRepository;
        this.userRepository = userRepository;
    }

    public Boolean isExistSender(Long id) {
        return senderRepository.existsById(id);
    }

    public Sender addSender(SenderRequest request) {
        if (!userRepository.existAndNoHaveSenderAccountUser(request.getUserId())) {
            throw new RestClientException("Пользователь не существует, либо у пользователя уже имеется созданный аккаунт");
        }
        User user = userRepository.findUserById(request.getUserId());
        Sender sender = new Sender();
        sender.setName(request.getName());
        sender.setCreatedAt(LocalDateTime.now());
        sender.setUser(user);
        return senderRepository.save(sender);
    }

    public Sender findSenderById(Long id) {
        return senderRepository.findById(id).get();
    }

    public List<Sender> getAll() {
        return senderRepository.findAll();
    }
}
