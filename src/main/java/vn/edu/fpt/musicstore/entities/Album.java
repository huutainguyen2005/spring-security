package vn.edu.fpt.musicstore.entities;

import jakarta.persistence.*;

@Entity
public class Album {
    @Id
    @Column(name = "albumid")
    private int albumId;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "artistid")
    private Artist artist;

    public Album() {
    }

    public Album(int albumId, String title, Artist artist) {
        this.albumId = albumId;
        this.title = title;
        this.artist = artist;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
