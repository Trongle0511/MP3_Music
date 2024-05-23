package com.example.music_mp3.Repository;

import com.example.music_mp3.Entity.SongsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<SongsEntity, Integer> {
    SongsEntity save(SongsEntity song);
    SongsEntity findById(int songID);
}
