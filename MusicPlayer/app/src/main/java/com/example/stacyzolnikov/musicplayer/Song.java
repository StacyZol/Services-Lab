package com.example.stacyzolnikov.musicplayer;

/**
 * Created by stacyzolnikov on 8/8/16.
 */
public class Song {
    private long id;
    private String title;
    private String artist;

    public Song(String title, long id, String artist) {
        this.title = title;
        this.id = id;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
