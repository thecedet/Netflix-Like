package fr.polytech.netflixbackend.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.polytech.netflixbackend.dto.request.SerieDtoCreate;
import fr.polytech.netflixbackend.dto.request.SerieDtoUpdate;
import fr.polytech.netflixbackend.entity.ActeurEntity;
import fr.polytech.netflixbackend.entity.SerieEntity;
import fr.polytech.netflixbackend.exception.ResourceNotFoundException;
import fr.polytech.netflixbackend.repository.SerieRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SerieService {
    
    private final SerieRepository serieRepository;

    private final S3Service s3Service;
    private final ActeurService acteurService;

    @Value("${s3.bucketName.cover}")
    public final String serieBucket = null;

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
            .acteurs(Collections.emptyList())
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

    public String getImage(Integer id) {
        SerieEntity serie = this.getSerie(id);
        if(!serie.isJacquette()) {
            throw new ResourceNotFoundException("L'acteur n'a pas d'image");
        }

        return s3Service.getImageUrl(id, serieBucket);
    }

    public String putImage(Integer id) {
        SerieEntity serie = this.getSerie(id);
        serie.setJacquette(true);
        serieRepository.save(serie);
        return s3Service.putImageUrl(id, serieBucket);
    }

    public SerieEntity addActeur(Integer idSerie, Integer idActeur) {
        ActeurEntity acteur = acteurService.getActeur(idActeur);
        SerieEntity serie = this.getSerie(idSerie);

        serie.getActeurs().add(acteur);
        serieRepository.save(serie);

        return serie;
    }
    
}
