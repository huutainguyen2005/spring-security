package vn.edu.fpt.musicstore.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artist {
    @Id
    @Column(name = "artistid")
    private int artistId;

    @Column(name = "name")
    private String artistName;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Album> albums;

    public Artist() {
    }

    public Artist(int artistId, String artistName, List<Album> albums) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.albums = albums;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}