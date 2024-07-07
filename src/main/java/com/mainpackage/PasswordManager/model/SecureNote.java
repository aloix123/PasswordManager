package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

@Entity
public class SecureNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long secureNoteid;
    @ManyToOne
    @JoinColumn(name = "elementid")
    private Element elementid;
    private String note;
    public SecureNote() {}
    public SecureNote(Element elementid, String note) {
        this.elementid = elementid;
        this.note = note;
    }

    public Long getSecureNoteid() {
        return secureNoteid;
    }

    public void setSecureNoteid(Long secureNoteid) {
        this.secureNoteid = secureNoteid;
    }

    public Element getElementid() {
        return elementid;
    }

    public void setElementid(Element elementid) {
        this.elementid = elementid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "SecureNote{" +
                "secureNoteid=" + secureNoteid +
                ", elementid=" + elementid +
                ", note='" + note + '\'' +
                '}';
    }
}
