package com.example.demo.pojo.senders;

import com.example.demo.pojo.AEntry;
import com.example.demo.pojo.messages.Message;
import com.example.demo.pojo.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name="senders")
public class Sender extends AEntry {
    private User user;
    private String name;
    private String color;
    private String logo;
    private List<Message> messages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        color = convertToColor(name);
        logo = name.substring(0, 1).toUpperCase();
        this.name = name;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    private static String convertToColor(String str) {
        int j = 0;
        int [] chars = new int[str.length()];
        for(int i: str.toCharArray()) {
            chars[j] = i;
            j++;
        }
        Color color;
        try{
            color = new Color(chars[0], chars[1], chars[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            color = new Color(128, 0, 128);
        }
        StringBuilder hex = new StringBuilder(Integer.toHexString(color.getRGB() & 0xffffff));
        return "#" + hex.toString();
    }
}
