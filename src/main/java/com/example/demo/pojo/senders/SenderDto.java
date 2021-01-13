package com.example.demo.pojo.senders;

import com.example.demo.pojo.AEntry;

public class SenderDto extends AEntry {
    private String name;
    private String color;
    private String logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
