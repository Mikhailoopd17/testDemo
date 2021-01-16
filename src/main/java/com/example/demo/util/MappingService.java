package com.example.demo.util;

import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.messages.MessageListDto;
import com.example.demo.pojo.messages.MessageRequestDto;
import com.example.demo.pojo.messages.MessageResponseDto;
import com.example.demo.pojo.senders.Sender;
import com.example.demo.pojo.senders.SenderDto;
import com.example.demo.repo.MessageRepository;
import com.example.demo.repo.SenderRepository;
import com.example.demo.repo.UserRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingService implements BaseMapping {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final SenderRepository senderRepository;

    public MappingService(ModelMapper modelMapper, UserRepository userRepository, MessageRepository messageRepository, SenderRepository senderRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.senderRepository = senderRepository;
    }

    @PostConstruct
    public void init(){
//        Converter<Long, UserDto> user =
//                mappingContext -> map(userRepository.findUserById(mappingContext.getSource()), UserDto.class);
//        modelMapper.typeMap(User.class, UserDto.class)
//                .addMappings(mapping -> mapping.using(user).map(User::getId, UserDto::setFirstName));

//        Converter<Long, MessageResponseDto> senderMessage =
//                mappingContext -> map(messageRepository.findMessageById(mappingContext.getSource()), MessageResponseDto.class);
//        modelMapper.typeMap(Message.class, MessageResponseDto.class)
//                .addMappings(mapping -> mapping.using(senderMessage).map(Message::getId, MessageResponseDto::setSender));

        Converter<Long, Sender> senderMessage =
                mappingContext -> map(senderRepository.findById(mappingContext.getSource()).get(), Sender.class);        // TODO: 14.01.2021 переписать метод findById для senders


        modelMapper.typeMap(MessageRequestDto.class, MessageResponseDto.class)
                .addMappings(mapping -> mapping.using(senderMessage).map(MessageRequestDto::getSenderId, MessageResponseDto::setSender));
        modelMapper.typeMap(MessageRequestDto.class, Message.class)
                .addMappings(mapping -> mapping.using(senderMessage).map(MessageRequestDto::getSenderId, Message::setSender));

        //senderDto
        Converter<Long, SenderDto> senderDto =
                mappingContext -> map(senderRepository.findById(mappingContext.getSource()).get(), SenderDto.class);
        modelMapper.typeMap(Message.class, MessageListDto.class)
                .addMappings(mapping -> mapping.using(senderDto).map(Message::getSenderId, MessageListDto::setSender));
    }

    public <S, D> D map(S source, Class<D> clazz) {
        return modelMapper.map(source, clazz);
    }

    public <S, D> void map(S source, D dest) {
        modelMapper.map(source, dest);
    }

    public <S, D> List<D> mapList(List<S> sources, Class<D> clazz){
        return sources.stream()
                .map(s -> map(s, clazz))
                .collect(Collectors.toList());
    }
}
