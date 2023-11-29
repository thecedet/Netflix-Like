package fr.polytech.netflixbackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.polytech.netflixbackend.entity.CommentaireEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentaireDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("auteur")
    private String auteur;
    
    @JsonProperty("note")
    private Integer note;
    
    @JsonProperty("commentaire")
    private String commentaire;
    
    public static CommentaireDto convertEntitytoDto(CommentaireEntity commentaire) {
        return CommentaireDto.builder()
            .id(commentaire.getId())
            .auteur(commentaire.getAuteur())
            .note(commentaire.getNote())
            .commentaire(commentaire.getCommentaire())
            .build();
    }

}
