package com.example.demo.repo;

import com.example.demo.base.BaseDao;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.PageParams;
import com.example.demo.pojo.users.User;
import com.example.demo.pojo.users.UserParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements BaseDao<User, UserParams> {
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
    public Page<User> list(PageParams<UserParams> params) {
        return new Page<>(repository.list(), (long) repository.list().size());
    }
}
