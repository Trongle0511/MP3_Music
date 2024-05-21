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
@Table(name = "Artists")
public class ArtistsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artistID;

    @Column(name = "ArtistName", nullable = false, length = 100)
    private String artistName;

    @Column(name = "ArtistImage")
    private String artistImage;

    @OneToMany(mappedBy = "artist")
    private List<SongsEntity> songs;

    @OneToMany(mappedBy = "artist")
    private List<AlbumsEntity> albums;
}
