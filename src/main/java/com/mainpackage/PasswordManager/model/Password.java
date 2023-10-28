package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

@Entity
public class Password {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long passwordid;
    @ManyToOne
    @JoinColumn(name = "folderid", referencedColumnName = "folderid")
    private Folder folder;
    private String password;
    private String URL;
    private String name;
    private String login;

    public Password() {
    }

    public Password(Long passwordid, Folder folder, String password, String URL, String name, String login) {
        this.passwordid = passwordid;
        this.folder = folder;
        this.password = password;
        this.URL = URL;
        this.name = name;
        this.login = login;
    }

    public Long getPasswordid() {
        return passwordid;
    }

    public void setPasswordid(Long passwordid) {
        this.passwordid = passwordid;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
