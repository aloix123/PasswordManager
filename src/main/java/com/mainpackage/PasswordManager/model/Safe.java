package com.mainpackage.PasswordManager.model;
import jakarta.persistence.*;

@Entity
public class Safe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long safeid;
    @ManyToOne
    @JoinColumn(name = "userid")
    private CustomUser customUser;
    private String name;
    public Safe(){

    }
    public Safe(CustomUser customUser, String name) {
        this.customUser = customUser;
        this.name = name;
    }

    public Long getSafeid() {
        return safeid;
    }

    public void setSafeid(Long safeid) {
        this.safeid = safeid;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Safe{" +
                "safeid=" + safeid +
                ", customUser=" + customUser +
                ", name='" + name + '\'' +
                '}';
    }
}
