package com.example.demo.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="senders")
@Getter
@Setter
public class Sender extends AEntry {
    private String name;

    @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
    private List<Message> messages;
}
