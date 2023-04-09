package com.tomasagata.tutorialspring.controllers;

import com.tomasagata.tutorialspring.entities.AlbumEntity;
import com.tomasagata.tutorialspring.services.BusinessServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class tutorialController {

    @Autowired
    private BusinessServices businessServices;

    @GetMapping("/health")
    public ResponseEntity<?> getHealth() {
        return new ResponseEntity<>(
                        "Servicio funcionando correctamente!",
                        HttpStatus.OK
                );
    }

    @GetMapping("/cantAlbumes")
    public ResponseEntity<?> cantidadDeAlbumesPorArtista(@RequestParam(name = "artista") String id_artista) {
        return
                new ResponseEntity<>(
                        businessServices.getAlbumCountByArtistId(Long.valueOf(id_artista)),
                        HttpStatus.OK
                );
    }

    @PostMapping("/album")
    public ResponseEntity<?> createAlbum(
            @RequestParam(name = "nombre", required = true) String nombreAlbum,
            @RequestParam(name = "artista", required = true) Long id_artista,
            @RequestParam(name = "genero", required = true) Long id_genero,
            @RequestParam(name = "fechasalida", required = false) Optional<java.sql.Date> fechaSalida) {

        AlbumEntity newAlbum = businessServices.createNewAlbum(
                nombreAlbum,
                fechaSalida.orElse(null),
                id_artista,
                id_genero
        );
        if (newAlbum != null){
            return new ResponseEntity<>(
                    newAlbum,
                    HttpStatus.CREATED
            );
        }

        return new ResponseEntity<>(
                "Artista o género inválido",
                HttpStatus.BAD_REQUEST
        );

    }

}
