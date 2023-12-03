package fr.polytech.netflixbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.polytech.netflixbackend.dto.request.ActeurDtoCreate;
import fr.polytech.netflixbackend.dto.request.ActeurDtoUpdate;
import fr.polytech.netflixbackend.entity.ActeurEntity;
import fr.polytech.netflixbackend.entity.SerieEntity;
import fr.polytech.netflixbackend.exception.ResourceNotFoundException;
import fr.polytech.netflixbackend.repository.ActeurRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActeurService {

    private final ActeurRepository acteurRepository;
    private final S3Service s3Service;

    @Value("${s3.bucketName.acteur}")
    public final String acteurBucket = null;

    public List<ActeurEntity> getActeurs() {
        return acteurRepository.findAll();
    }

    public ActeurEntity getActeur(Integer id) {
        return acteurRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("L'ID de l'acteur est introuvable")
        );
    }

    public ActeurEntity addActeur(ActeurDtoCreate acteurDtoCreate) {
        final ActeurEntity acteurEntity = ActeurEntity.builder()
            .nom(acteurDtoCreate.getNom())
            .prenom(acteurDtoCreate.getPrenom())
            .build();

        acteurRepository.save(acteurEntity);
        return acteurEntity;
    }

    public ActeurEntity editActeur(Integer id, ActeurDtoUpdate acteurDtoUpdate) {
        final ActeurEntity acteur = this.getActeur(id);

        if(acteurDtoUpdate.getNom() != null) acteur.setNom(acteurDtoUpdate.getNom());
        if(acteurDtoUpdate.getPrenom() != null) acteur.setPrenom(acteurDtoUpdate.getPrenom());

        acteurRepository.save(acteur);

        return acteur;
    }

    public String deleteActeur(Integer id) {
        ActeurEntity acteur = this.getActeur(id);
        for(SerieEntity serie : acteur.getSeries()) {
            serie.getActeurs().remove(acteur);
        }
        this.acteurRepository.delete(acteur);
        return "L'acteur vient d'être supprimé";
    }

    public String getImage(Integer id) {
        ActeurEntity acteur = this.getActeur(id);

        if(!acteur.isImage()) {
            throw new ResourceNotFoundException("L'acteur n'a pas d'image");
        }

        return s3Service.getImageUrl(id, acteurBucket);
    }

    public String putImage(Integer id) {
        ActeurEntity acteur = this.getActeur(id);
        acteur.setImage(true);
        acteurRepository.save(acteur);
        return s3Service.putImageUrl(id, acteurBucket);
    }

}
