package com.example.demo.pojo.users;

import com.example.demo.base.AEntry;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends AEntry {
    private String firstName;
    private String secondName;
    private String lastName;
    private UserCredential credential;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    @JsonIgnore
//    public UserCredential getCredential() {
//        return credential;
//    }
//
//    public void setCredential(UserCredential credential) {
//        this.credential = credential;
//    }

    class UserCredential {
        private String login = "admin";
        private String password = "admin";
        private String email;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
