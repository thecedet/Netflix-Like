package fr.polytech.netflixbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.polytech.netflixbackend.dto.request.ActeurDtoCreate;
import fr.polytech.netflixbackend.dto.request.ActeurDtoUpdate;
import fr.polytech.netflixbackend.entity.ActeurEntity;
import fr.polytech.netflixbackend.exception.ResourceNotFoundException;
import fr.polytech.netflixbackend.repository.ActeurRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ActeurService {

    private final ActeurRepository acteurRepository;

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
        this.getActeur(id);
        this.acteurRepository.deleteById(id);
        return "L'acteur vient d'être supprimé";
    }

}
