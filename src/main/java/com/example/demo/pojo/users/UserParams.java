package com.example.demo.pojo.users;

import com.example.demo.base.BaseParams;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class UserParams extends BaseParams {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updated_at;
    private String firstName;
    private String secondName;
    private String lastName;
}
