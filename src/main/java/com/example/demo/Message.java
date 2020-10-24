package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Message {
    private int id;
    private  String name;
    private LocalDateTime date;
}
