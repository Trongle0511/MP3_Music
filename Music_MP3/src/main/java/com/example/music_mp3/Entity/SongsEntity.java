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
@Table(name = "Songs")
public class SongsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int songID;

    @Column(name = "SongName", nullable = false, length = 100)
    private String songName;

    @ManyToOne
    @JoinColumn(name = "AlbumID")
    private AlbumsEntity album;

    @ManyToOne
    @JoinColumn(name = "ArtistID")
    private ArtistsEntity artist;

    @Lob
    @Column(name = "SongImage")
    private String songImage;

    @Lob
    @Column(name = "SongAudio")
    private byte[] songAudio;

    @OneToMany(mappedBy = "song")
    private List<SongGenresEntity> songGenres;

    @OneToMany(mappedBy = "song")
    private List<SongRatingsEntity> songRatings;

    @OneToMany(mappedBy = "song")
    private List<PlaylistSongsEntity> playlistSongs;
}
