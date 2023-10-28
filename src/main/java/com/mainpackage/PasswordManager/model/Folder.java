package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"folder\"")
public  class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long folderid;
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    String foldername;

    String desctyprion;

    public Folder() {
    }

    public Folder(Long folderid, User userid, String foldername, String desctyprion) {
        this.folderid = folderid;
        this.user = userid;
        this.foldername = foldername;
        this.desctyprion = desctyprion;
    }

    public Long getFolderid() {
        return folderid;
    }

    public void setFolderid(Long folderid) {
        this.folderid = folderid;
    }



    public String getFoldername() {
        return foldername;
    }

    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }

    public String getDesctyprion() {
        return desctyprion;
    }

    public void setDesctyprion(String desctyprion) {
        this.desctyprion = desctyprion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
