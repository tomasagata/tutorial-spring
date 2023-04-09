package com.tomasagata.tutorialspring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
public class GeneroEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genero;

    @Getter
    @Setter
    @NonNull
    @Column
    private String nombre;

    public GeneroEntity() {}

}
