package com.example.music_mp3.Api;

import com.example.music_mp3.Entity.SongsEntity;
import com.example.music_mp3.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongApi {
    @Autowired
    private SongService songService;

    @GetMapping("/findSongId")
    public ResponseEntity<?> findSongId(@RequestParam("songId") int songId) {
        return  ResponseEntity.ok(songService.findById(songId));
    }
}
