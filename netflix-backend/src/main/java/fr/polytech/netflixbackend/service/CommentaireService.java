package fr.polytech.netflixbackend.service;

import org.springframework.stereotype.Service;

import fr.polytech.netflixbackend.dto.request.CommentaireDtoCreate;
import fr.polytech.netflixbackend.dto.request.CommentaireDtoUpdate;
import fr.polytech.netflixbackend.entity.CommentaireEntity;
import fr.polytech.netflixbackend.entity.SerieEntity;
import fr.polytech.netflixbackend.exception.ResourceNotFoundException;
import fr.polytech.netflixbackend.repository.CommentaireRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentaireService {
    
    private final CommentaireRepository commentaireRepository;
    private final SerieService serieService;

    public CommentaireEntity addCommentaire(Integer id, CommentaireDtoCreate commentaireDtoCreate) {
        final SerieEntity serie = this.serieService.getSerie(id);
        final CommentaireEntity commentaire = CommentaireEntity.builder()
            .auteur(commentaireDtoCreate.getAuteur())
            .note(commentaireDtoCreate.getNote())
            .commentaire(commentaireDtoCreate.getCommentaire())
            .serie(serie)
            .build();

        commentaireRepository.save(commentaire);
        return commentaire;
    }

    public CommentaireEntity getCommentaire(Integer id) {
        return this.commentaireRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("L'ID du commentaire est introuvable")
        );
    }

    public String deleteSerie(Integer id) {
        this.getCommentaire(id);
        this.commentaireRepository.deleteById(id);
        return "Le commentaire vient d'être supprimé";
    }

    public CommentaireEntity editCommentaire(Integer id, CommentaireDtoUpdate Commentairedto) {
        final CommentaireEntity commentaire = this.getCommentaire(id);
        
        if(Commentairedto.getAuteur() != null) commentaire.setAuteur(Commentairedto.getAuteur());
        if(Commentairedto.getNote() != null) commentaire.setNote(Commentairedto.getNote());
        if(Commentairedto.getCommentaire() != null) commentaire.setCommentaire(Commentairedto.getCommentaire());
        if(Commentairedto.getScreenshot() != null) commentaire.setScreenshot(Commentairedto.getScreenshot());

        commentaireRepository.save(commentaire);

        return commentaire;
    }
    
}
