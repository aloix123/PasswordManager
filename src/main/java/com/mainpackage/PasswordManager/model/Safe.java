package com.mainpackage.PasswordManager.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Safe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long safeid;
    private Long userid;
    private String name;
}