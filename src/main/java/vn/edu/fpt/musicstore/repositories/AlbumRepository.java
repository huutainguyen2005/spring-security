package vn.edu.fpt.musicstore.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.musicstore.entities.Album;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    List<Album> findByAlbumId(int albumId);

    Page<Album> findByAlbumId(int albumId, Pageable pageable);
}
