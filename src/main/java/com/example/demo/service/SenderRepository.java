package com.example.demo.service;

import com.example.demo.pojo.senders.Sender;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

public interface SenderRepository extends JpaRepository<Sender, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into senders " +
            "(created_at, name, color, logo, user_id) " +
            "values (now(), #{sender.name}, #{sender.color}, #{sender.logo}, #{sender.userId})",
            nativeQuery = true)
    Integer save1(@Param("sender") Sender sender);


}
