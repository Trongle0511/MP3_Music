package com.example.music_mp3.Entity;

import jakarta.persistence.*;
import lombok.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts") // Đảm bảo tên bảng trong cơ sở dữ liệu là 'accounts'
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String email;

    private String hashedPassword;

    private boolean is_disable;

    private boolean is_admin;
}

