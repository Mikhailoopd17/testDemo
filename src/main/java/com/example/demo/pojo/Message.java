package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Message {
    private int id;
    private String text;
    private LocalDateTime date;
}
