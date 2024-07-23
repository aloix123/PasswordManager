package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecureNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long secureNoteid;
    private Long elementid;
    private String note;
}