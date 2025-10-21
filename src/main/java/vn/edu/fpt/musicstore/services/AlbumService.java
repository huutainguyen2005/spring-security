package vn.edu.fpt.musicstore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.fpt.musicstore.entities.Album;
import vn.edu.fpt.musicstore.repositories.AlbumRepository;

import java.util.List;

@Service
public class AlbumService {

    private AlbumRepository albumRepository;
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public List<Album> getLists() {
        return albumRepository.findAll();
    }

    public Page<Album> getAllAlbums(Pageable pageable) {
        return albumRepository.findAll(pageable);
    }
}
