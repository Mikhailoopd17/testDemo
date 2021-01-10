package com.example.demo.repo;

import com.example.demo.base.BaseDao;
import com.example.demo.pojo.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements BaseDao<User> {
    private UserRepository repository;

    @Autowired
    public UserRepositoryImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User entity) {
        return repository.save(entity);
    }

    @Override
    public User getById(Long id) {
        return repository.findUserById(id);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public List<User> list() {
        return repository.list();
    }
}
