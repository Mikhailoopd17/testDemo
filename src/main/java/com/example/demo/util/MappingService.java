package com.example.demo.util;

import com.example.demo.pojo.messages.MessageListDTO;
import com.example.demo.pojo.senders.Sender;
import com.example.demo.pojo.senders.SenderLogoDTO;
import com.example.demo.service.SenderService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingService implements BaseMapping {
    private final ModelMapper modelMapper;
    private final SenderService senderService;

    public MappingService(ModelMapper modelMapper, SenderService senderService) {
        this.modelMapper = modelMapper;
        this.senderService = senderService;
    }

    @PostConstruct
    public void init() {
        //Course
        Converter<Long, SenderLogoDTO> senderLogo =
                mappingContext -> map(senderService.findSenderById(mappingContext.getSource()), SenderLogoDTO.class);

        modelMapper.typeMap(Sender.class, MessageListDTO.class)
                .addMappings(mapping -> mapping.using(senderLogo).map(Sender::getId, MessageListDTO::setSender));
    }

    @Override
    public <S, D> D map(S source, Class<D> clazz) {
        return modelMapper.map(source, clazz);
    }

    @Override
    public <S, D> void map(S source, D dest) {
        modelMapper.map(source, dest);
    }

    @Override
    public <S, D> List<D> mapList(List<S> sources, Class<D> clazz) {
        return sources.stream()
                .map(s -> map(s, clazz))
                .collect(Collectors.toList());
    }
}
