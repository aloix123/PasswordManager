package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;

@Entity
public class PasswordHint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hintid;
    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;
    private String hint;

    public PasswordHint() {
    }

    public PasswordHint(Long hintid, User userid, String hint) {
        this.hintid = hintid;
        this.user = userid;
        this.hint = hint;
    }

    public Long getHintid() {
        return hintid;
    }

    public void setHintid(Long hintid) {
        this.hintid = hintid;
    }

    public User getUserid() {
        return user;
    }

    public void setUserid(User userid) {
        this.user = userid;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
