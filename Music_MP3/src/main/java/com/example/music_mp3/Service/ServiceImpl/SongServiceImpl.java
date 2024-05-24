package com.example.music_mp3.Service.ServiceImpl;

import com.example.music_mp3.Entity.SongsEntity;
import com.example.music_mp3.Repository.SongRepo;
import com.example.music_mp3.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepo songRepo;

    @Override
    public SongsEntity save(SongsEntity song) {
        return songRepo.save(song);
    }

    @Override
    public SongsEntity findById(int songID) {
        return songRepo.findById(songID);
    }


}
