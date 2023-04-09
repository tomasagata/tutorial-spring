package com.tomasagata.tutorialspring.repositories;

import com.tomasagata.tutorialspring.entities.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity, Long> {
}
