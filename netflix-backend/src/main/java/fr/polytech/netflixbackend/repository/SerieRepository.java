package fr.polytech.netflixbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.polytech.netflixbackend.entity.SerieEntity;

public interface SerieRepository extends JpaRepository<SerieEntity, Integer>{
    
    public List<SerieEntity> findAllByOrderByDateSortie();

}
