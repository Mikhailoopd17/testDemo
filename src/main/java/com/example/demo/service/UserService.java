package com.example.demo.service;

import com.example.demo.base.BaseService;
import com.example.demo.pojo.users.User;
import com.example.demo.pojo.users.UserDto;
import com.example.demo.pojo.users.UserListDto;
import com.example.demo.pojo.users.UserParams;
import com.example.demo.repo.UserRepositoryImpl;
import com.example.demo.util.MappingService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserListDto, UserDto, UserDto, UserParams, User> {

    public UserService(UserRepositoryImpl baseDao, MappingService mappingService) {
        super(baseDao, UserDto.class, User.class, mappingService, UserDto.class, UserListDto.class);
    }
}
