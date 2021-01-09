package com.example.demo.api;

import com.example.demo.base.AbstractController;
import com.example.demo.pojo.users.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${web.prefix}/users", produces = "application/json; charset=UTF-8")
public class UserController extends AbstractController<User, UserService> {
    public UserController(UserService userService) {
        super(userService);
    }
}
