package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

@Entity
public class LoginData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loginDataid;
    @ManyToOne
    @JoinColumn(name = "elementid")
    private Element elementid;
    private String userName;
    private String password;
    private String URL;
    private String descryption;
    public LoginData() {}
    public LoginData(Element elementid, String userName, String password, String URL, String descryption) {
        this.elementid = elementid;
        this.userName = userName;
        this.password = password;
        this.URL = URL;
        this.descryption = descryption;
    }

    public Long getLoginDataid() {
        return loginDataid;
    }

    public void setLoginDataid(Long loginDataid) {
        this.loginDataid = loginDataid;
    }

    public Element getElementid() {
        return elementid;
    }

    public void setElementid(Element elementid) {
        this.elementid = elementid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "loginDataid=" + loginDataid +
                ", elementid=" + elementid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", URL='" + URL + '\'' +
                ", descryption='" + descryption + '\'' +
                '}';
    }
}
