package com.tomasagata.tutorialspring.repositories;

import com.tomasagata.tutorialspring.entities.ArtistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<ArtistaEntity, Long> {
}
