package vn.edu.fpt.musicstore.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.fpt.musicstore.entities.Artist;
import vn.edu.fpt.musicstore.repositories.ArtistRepository;

import java.util.List;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }
    public Artist findById(int id) {
        return artistRepository.findById(id).orElse(null);
    }
    @Transactional
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }
    @Transactional
    public void deleteById(int id) {
        artistRepository.deleteById(id);
    }

    public List<Artist> getLists() {
        return artistRepository.findAll();
    }

    public Page<Artist> getAllArtists(Pageable pageable) {
        return artistRepository.findAll(pageable);
    }

}