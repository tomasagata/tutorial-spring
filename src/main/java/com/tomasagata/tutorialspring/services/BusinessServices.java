package com.tomasagata.tutorialspring.services;

import com.tomasagata.tutorialspring.entities.AlbumEntity;
import com.tomasagata.tutorialspring.entities.ArtistaEntity;
import com.tomasagata.tutorialspring.entities.GeneroEntity;
import com.tomasagata.tutorialspring.repositories.AlbumRepository;
import com.tomasagata.tutorialspring.repositories.ArtistaRepository;
import com.tomasagata.tutorialspring.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusinessServices {

    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private ArtistaRepository artistaRepo;
    @Autowired
    private GeneroRepository generoRepo;

    public int getAlbumCountByArtistId(Long artist_id) {
        return albumRepo.selectAllAlbumsByArtistId(artist_id).size();
    }

    public AlbumEntity createNewAlbum(String nombre, java.sql.Date fechaSalida, Long id_artista, Long id_genero) {
        AlbumEntity newAlbum = null;
        Optional<GeneroEntity> genero = generoRepo.findById(id_genero);
        Optional<ArtistaEntity> artista = artistaRepo.findById(id_artista);

        if(genero.isPresent() && artista.isPresent()){
            newAlbum = albumRepo.save(
                    new AlbumEntity(nombre, fechaSalida, genero.get(), artista.get())
            );
        }

        return newAlbum;
    }

}
