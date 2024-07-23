package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginDataid;
    private Long elementid;
    private String userName;
    private String password;
    private String URL;
    private String descryption;
}