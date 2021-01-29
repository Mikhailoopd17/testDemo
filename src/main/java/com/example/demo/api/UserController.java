package com.example.demo.api;

import com.example.demo.base.BaseController;
import com.example.demo.base.BaseService;
import com.example.demo.pojo.users.User;
import com.example.demo.pojo.users.UserDto;
import com.example.demo.pojo.users.UserListDto;
import com.example.demo.pojo.users.UserParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users", produces = "application/json; charset=UTF-8")
public class UserController extends BaseController<UserListDto, UserDto, UserDto, UserParams, User> {

    @Autowired
    public UserController(BaseService<UserListDto, UserDto, UserDto, UserParams, User> service) {
        super(service);
    }
}
