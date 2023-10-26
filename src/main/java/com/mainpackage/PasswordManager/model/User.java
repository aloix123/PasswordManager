package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue
    private Long userid;
    private String mainPassword;
    private String email;
    private String login;
    public User(Long userid, String mainpassword, String email, String login) {
        this.userid = userid;
        this.mainPassword = mainpassword;
        this.email = email;
        this.login = login;
    }

    public User() {
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getMainPassword() {
        return mainPassword;
    }

    public void setMainPassword(String mainPassword) {
        this.mainPassword = mainPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
