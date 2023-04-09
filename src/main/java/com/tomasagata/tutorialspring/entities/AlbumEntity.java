package com.tomasagata.tutorialspring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
public class AlbumEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_album;

    @Getter
    @Setter
    @NonNull
    @Column
    private String nombre;

    @Getter
    @Setter
    @Column
    private java.sql.Date fechaSalida;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(referencedColumnName = "id_genero")
    private GeneroEntity genero;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_artista")
    private ArtistaEntity artista;

    public AlbumEntity(){}

    public AlbumEntity(String nombre, java.sql.Date fechaSalida, GeneroEntity genero, ArtistaEntity artista) {
        this.nombre = nombre;
        this.fechaSalida = fechaSalida;
        this.genero = genero;
        this.artista = artista;
    }

}
