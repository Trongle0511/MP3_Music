package com.example.music_mp3.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
public class AccountsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Hashed_Password", nullable = false)
    private String hashedPassword;

    @Column(name = "is_disable")
    private boolean isDisable;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "account")
    private List<SongRatingsEntity> songRatings;

    @OneToMany(mappedBy = "account")
    private List<PlaylistsEntity> playlists;
}
