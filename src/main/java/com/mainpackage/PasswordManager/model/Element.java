package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long elementid;
    @ManyToOne
    @JoinColumn(name = "folderid")
    private Folder folderid;
    private String name;
    public Element(){}
    public Element( Folder folderid, String name) {
        this.folderid = folderid;
        this.name = name;
    }

    public Long getElementid() {
        return elementid;
    }

    public void setElementid(Long elementid) {
        this.elementid = elementid;
    }

    public Folder getFolderid() {
        return folderid;
    }

    public void setFolderid(Folder folderid) {
        this.folderid = folderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Element{" +
                "elementid=" + elementid +
                ", folderid=" + folderid +
                ", name='" + name + '\'' +
                '}';
    }
}
