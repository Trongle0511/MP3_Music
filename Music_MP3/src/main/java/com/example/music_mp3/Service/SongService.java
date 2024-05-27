package com.example.music_mp3.Service;


import com.example.music_mp3.Entity.SongsEntity;

public interface SongService {
    SongsEntity save(SongsEntity song);
    SongsEntity findById(int songID);
}
