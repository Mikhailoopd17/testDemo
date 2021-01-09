package com.example.demo.service;

        import com.example.demo.base.AbstractService;
        import com.example.demo.pojo.users.User;
        import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserRepository> {

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
