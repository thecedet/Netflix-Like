package fr.polytech.netflixbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.polytech.netflixbackend.entity.CommentaireEntity;

public interface CommentaireRepository extends JpaRepository<CommentaireEntity, Integer> {
    
}
