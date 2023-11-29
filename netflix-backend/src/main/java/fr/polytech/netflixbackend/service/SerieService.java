package fr.polytech.netflixbackend.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.polytech.netflixbackend.dto.request.SerieDtoCreate;
import fr.polytech.netflixbackend.dto.request.SerieDtoUpdate;
import fr.polytech.netflixbackend.entity.SerieEntity;
import fr.polytech.netflixbackend.exception.ResourceNotFoundException;
import fr.polytech.netflixbackend.repository.SerieRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SerieService {
    
    private final SerieRepository serieRepository;

    public List<SerieEntity> getSeries() {
        return serieRepository.findAllByOrderByDateSortie();
    }

    public SerieEntity getSerie(Integer id) {
        return serieRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("L'ID de la série est introuvable")
        );
    }

    public SerieEntity addSerie(SerieDtoCreate serieDtoCreate) {
        final SerieEntity serieEntity = SerieEntity.builder()
            .nom(serieDtoCreate.getNom())
            .description(serieDtoCreate.getDescription())
            .dateSortie(serieDtoCreate.getDateSortie())
            .commentaires(Collections.emptyList())
            .build();
        
        serieRepository.save(serieEntity);
        return serieEntity;
    }

    public SerieEntity editSerie(Integer id, SerieDtoUpdate serieDtoUpdate) {
        final SerieEntity serie = this.getSerie(id);
        
        if(serieDtoUpdate.getNom() != null) serie.setNom(serieDtoUpdate.getNom());
        if(serieDtoUpdate.getDescription() != null) serie.setDescription(serieDtoUpdate.getDescription());
        if(serieDtoUpdate.getDateSortie() != null) serie.setDateSortie(serieDtoUpdate.getDateSortie());

        serieRepository.save(serie);

        return serie;
    }

    public String deleteSerie(Integer id) {
        this.getSerie(id);
        this.serieRepository.deleteById(id);
        return "La série vient d'être supprimée";
    }

    public void addCover(Integer id, String extension) {
        final SerieEntity serie = this.getSerie(id);
        serie.setJacquette(extension);
        serieRepository.save(serie);
    }

    public String getCover(Integer id) {
        final SerieEntity serie = this.getSerie(id);
        final String jacquette = serie.getJacquette();

        if(jacquette == null) {
            throw new ResourceNotFoundException("La série n'a pas de jacquette");
        }
        return id+jacquette;
    }
    
}
