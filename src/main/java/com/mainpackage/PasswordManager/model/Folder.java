package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

@Entity
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long folderid;
    @ManyToOne
    @JoinColumn(name = "safeid")
    private Safe safeid;
    private  String name;
    public Folder(){}

    public Folder(Safe safeid, String name) {
        this.safeid = safeid;
        this.name = name;
    }

    public Long getFolderid() {
        return folderid;
    }

    public void setFolderid(Long folderid) {
        this.folderid = folderid;
    }

    public Safe getSafeid() {
        return safeid;
    }

    public void setSafeid(Safe safeid) {
        this.safeid = safeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "folderid=" + folderid +
                ", safeid=" + safeid +
                ", name='" + name + '\'' +
                '}';
    }
}
