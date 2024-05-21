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
@Table(name = "Genres")
public class GenresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreID;

    @Column(name = "GenreName", nullable = false, length = 50)
    private String genreName;

    @OneToMany(mappedBy = "genre")
    private List<SongGenresEntity> songGenres;
}
