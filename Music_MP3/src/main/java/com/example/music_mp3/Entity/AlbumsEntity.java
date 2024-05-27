package com.example.music_mp3.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Albums")
public class AlbumsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumID;

    @Column(name = "AlbumName", nullable = false, length = 100)
    private String albumName;

    @Column(name = "ReleaseYear")
    private Date releaseYear;

    @ManyToOne
    @JoinColumn(name = "ArtistID")
    private ArtistsEntity artist;

    @OneToMany(mappedBy = "album")
    private List<SongsEntity> songs;
}
