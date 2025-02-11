package com.example.music_mp3.Data.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private int SongID;
    private String song_name;
    private String Image;
    private String audio_file;
}
