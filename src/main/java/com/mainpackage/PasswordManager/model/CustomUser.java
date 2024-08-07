package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long userid;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String mainPassword;
    @Column(nullable = false, unique = true)
    private String email;
    @Lob
    private byte[] image;

    public boolean isSomeDataNull(){
        if(this.login.isEmpty() ||this.mainPassword.isEmpty() || this.email.isEmpty() ){
            return true;
        }
        else{
            return false;
        }
    }
}