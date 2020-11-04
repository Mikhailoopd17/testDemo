package com.example.demo.util;

import com.example.demo.pojo.Message;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MessageResponce {
    List<Message> messages;
    Integer size;
    Integer page;
    Integer totalPage;

}
