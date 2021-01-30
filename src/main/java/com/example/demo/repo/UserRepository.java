package com.example.demo.repo;

import com.example.demo.pojo.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select '*' from User where deleted = false")
    List<User> list();

    User findUserById(Long id);


    @Query(value = "select exists (" +
            "select 1 from users u " +
            "left join senders s on s.user_id = u.id " +
            "where u.id = :id and u.deleted_at is null " +
            "and s.id is null)", nativeQuery = true)
    Boolean existAndNoHaveSenderAccountUser(@Param("id") Long id);

}
