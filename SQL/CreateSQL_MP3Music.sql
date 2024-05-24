USE master;
GO

DROP DATABASE IF EXISTS DuAnMP3_Music;
GO

CREATE DATABASE DuAnMP3_Music;
GO

USE DuAnMP3_Music;
GO
-- Bảng Account
CREATE TABLE Account (
    user_Id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    hashed_password VARCHAR(255) NOT NULL,
    role BIT

);
-- Bảng User
CREATE TABLE Users (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    image VARCHAR(MAX),
	account_ID int null foreign key references Account(user_Id)
);
-- Bảng Nghệ sĩ (Artists)
CREATE TABLE Artists (
    ArtistID INT IDENTITY(1,1) PRIMARY KEY,
    ArtistName VARCHAR(100) NOT NULL
);

-- Bảng Album
CREATE TABLE Album (
    AlbumID INT IDENTITY(1,1) PRIMARY KEY,
    AlbumName VARCHAR(100) NOT NULL,
    ArtistID INT,
    FOREIGN KEY (ArtistID) REFERENCES Artists(ArtistID)
);

-- Bảng Thể loại (Genres)
CREATE TABLE Genres (
    GenreID INT IDENTITY(1,1) PRIMARY KEY,
    GenreName VARCHAR(50) NOT NULL
);

-- Bảng Bài hát (Songs)
CREATE TABLE Songs (
    SongID INT IDENTITY(1,1) PRIMARY KEY,
    SongName VARCHAR(100) NOT NULL,
    Image VARCHAR(MAX),
    AudioFile VARCHAR(MAX),
    AlbumID INT,
    ArtistID INT,
    GenreID INT,
    FOREIGN KEY (AlbumID) REFERENCES Album(AlbumID),
    FOREIGN KEY (ArtistID) REFERENCES Artists(ArtistID),
    FOREIGN KEY (GenreID) REFERENCES Genres(GenreID)
);

-- Bảng Đánh giá bài hát (SongRatings)
CREATE TABLE SongRatings (
    SongID INT,
    Views INT NOT NULL,
    UserID INT,
    FOREIGN KEY (SongID) REFERENCES Songs(SongID),
    FOREIGN KEY (UserID) REFERENCES Account(user_Id),
    PRIMARY KEY (SongID, UserID)
);

-- Bảng Playlist
CREATE TABLE Playlist (
    PlaylistID INT IDENTITY(1,1) PRIMARY KEY,
    PlaylistName VARCHAR(100) NOT NULL,
    Description TEXT,
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES Account(user_Id)
);

-- Bảng Chi tiết bài hát trong playlist (PlaylistSongs)
CREATE TABLE PlaylistSongs (
    PlaylistID INT,
    SongID INT,
    FOREIGN KEY (PlaylistID) REFERENCES Playlist(PlaylistID),
    FOREIGN KEY (SongID) REFERENCES Songs(SongID),
    PRIMARY KEY (PlaylistID, SongID)
);
