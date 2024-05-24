package com.example.music_mp3.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class AccountsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Hashed_Password", nullable = false)
    private String hashedPassword;

    @Column(name = "role")
    private Boolean role;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private UserEntity user;
}
