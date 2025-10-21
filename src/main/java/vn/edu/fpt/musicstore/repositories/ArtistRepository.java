package vn.edu.fpt.musicstore.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.musicstore.entities.Artist;

import java.util.List;


@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    List<Artist> findByArtistNameContainingIgnoreCase(String artistName);

    Page<Artist> findByArtistNameContainingIgnoreCase(String artistName, Pageable pageable);

}