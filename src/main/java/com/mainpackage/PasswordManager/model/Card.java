package com.mainpackage.PasswordManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardid;
    private Long elementid;
    private String owner;
    private String publisher;
    private String numbers;
    private String secureCode;
    private String descryption;
}