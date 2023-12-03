package fr.polytech.netflixbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.polytech.netflixbackend.entity.ActeurEntity;

public interface ActeurRepository extends JpaRepository<ActeurEntity, Integer> {
    
}

