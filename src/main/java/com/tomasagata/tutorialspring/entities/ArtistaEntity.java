package com.tomasagata.tutorialspring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
public class ArtistaEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_artista;

    @Getter
    @Setter
    @NonNull
    @Column
    private String nombre;

    public ArtistaEntity() {}

}
