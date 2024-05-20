use master
go

drop database if exists DuAnMP3_Music
go

create database DuAnMP3_Music
go

use DuAnMP3_Music
go

-- Bảng tài khoản người dùng
CREATE TABLE Accounts (
    ID INT PRIMARY KEY IDENTITY(1,1),
    Username NVARCHAR(50) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Hashed_Password NVARCHAR(255) NOT NULL,
	is_disable      bit default 0,
    is_admin        bit
);

-- Bảng nghệ sĩ
CREATE TABLE Artists (
    ArtistID INT PRIMARY KEY IDENTITY(1,1),
    ArtistName NVARCHAR(100) NOT NULL,
    DOB DATE,
    Country NVARCHAR(50)
);

-- Bảng album
CREATE TABLE Albums (
    AlbumID INT PRIMARY KEY IDENTITY(1,1),
    AlbumName NVARCHAR(100) NOT NULL,
    ReleaseYear date,
    ArtistID INT,
    FOREIGN KEY (ArtistID) REFERENCES Artists(ArtistID)
);

-- Bảng bài hát
CREATE TABLE Songs (
    SongID INT PRIMARY KEY IDENTITY(1,1),
    SongName NVARCHAR(100) NOT NULL,
    Duration TIME,
    AlbumID INT,
    ArtistID INT,
    FOREIGN KEY (AlbumID) REFERENCES Albums(AlbumID),
    FOREIGN KEY (ArtistID) REFERENCES Artists(ArtistID)
);

-- Bảng thể loại
CREATE TABLE Genres (
    GenreID INT PRIMARY KEY IDENTITY(1,1),
    GenreName NVARCHAR(50) NOT NULL
);

-- Bảng chi tiết thể loại của bài hát
CREATE TABLE SongGenres (
    SongID INT,
    GenreID INT,
    PRIMARY KEY (SongID, GenreID),
    FOREIGN KEY (SongID) REFERENCES Songs(SongID),
    FOREIGN KEY (GenreID) REFERENCES Genres(GenreID)
);

-- Bảng đánh giá bài hát
CREATE TABLE SongRatings (
    SongID INT,
    Rating INT CHECK (Rating BETWEEN 1 AND 5),
    UserID INT,
    PRIMARY KEY (SongID, UserID),
    FOREIGN KEY (SongID) REFERENCES Songs(SongID),
    FOREIGN KEY (UserID) REFERENCES Accounts(ID)
);

-- Bảng playlist
CREATE TABLE Playlists (
    PlaylistID INT PRIMARY KEY IDENTITY(1,1),
    PlaylistName NVARCHAR(100) NOT NULL,
    Description NVARCHAR(255),
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES Accounts(ID)
);

-- Bảng chi tiết bài hát trong playlist
CREATE TABLE PlaylistSongs (
    PlaylistID INT,
    SongID INT,
    PRIMARY KEY (PlaylistID, SongID),
    FOREIGN KEY (PlaylistID) REFERENCES Playlists(PlaylistID),
    FOREIGN KEY (SongID) REFERENCES Songs(SongID)
);
