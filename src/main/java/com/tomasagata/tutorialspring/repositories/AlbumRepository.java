package com.tomasagata.tutorialspring.repositories;

import com.tomasagata.tutorialspring.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

    @Query("SELECT album FROM AlbumEntity album WHERE album.artista.id_artista = :id_artista")
    List<AlbumEntity> selectAllAlbumsByArtistId(@Param("id_artista") Long artist_id);

}
