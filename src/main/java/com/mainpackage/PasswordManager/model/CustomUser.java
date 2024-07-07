package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long userid;
    private String login;
    private String mainPassword;
    private String email;
    private byte[] image;
    public CustomUser(){

    }
    public CustomUser(String login, String mainPassword, String email, byte[] image) {
        this.login = login;
        this.mainPassword = mainPassword;
        this.email = email;
        this.image = image;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", login='" + login + '\'' +
                ", mainPassword='" + mainPassword + '\'' +
                ", email='" + email + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
