package fr.polytech.netflixbackend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.netflixbackend.dto.request.CommentaireDtoCreate;
import fr.polytech.netflixbackend.dto.request.CommentaireDtoUpdate;
import fr.polytech.netflixbackend.dto.response.CommentaireDto;
import fr.polytech.netflixbackend.dto.response.MessageDto;
import fr.polytech.netflixbackend.service.CommentaireService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentaireController {
    
    private final CommentaireService commentaireService;

    @PostMapping("/series/{id}/commentaire")
    public @ResponseBody CommentaireDto addCommentaire(@Valid @RequestBody CommentaireDtoCreate commentaireDtoCreate, @PathVariable Integer id) {
        return CommentaireDto.convertEntitytoDto(this.commentaireService.addCommentaire(id, commentaireDtoCreate));
    }

    @DeleteMapping("/commentaires/{id}")
    public @ResponseBody MessageDto deleteCommentaire(@PathVariable Integer id) {
        return MessageDto.builder()
            .code("OK_DELETE")
            .message(this.commentaireService.deleteSerie(id))
            .build();
    }

    @PutMapping("/commentaires/{id}")
    public @ResponseBody CommentaireDto editCommentaire(@Valid @RequestBody CommentaireDtoUpdate commentaireUpdate, @PathVariable Integer id) {
        return CommentaireDto.convertEntitytoDto(this.commentaireService.editCommentaire(id, commentaireUpdate));
    }

}
