package fr.polytech.netflixbackend.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.polytech.netflixbackend.entity.SerieEntity;
import fr.polytech.netflixbackend.service.CommentaireService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SerieDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date_sortie")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateSortie;

    @JsonProperty("commentaire")
    private List<CommentaireDto> commentaires;

    @JsonProperty("note_moyenne")
    private float noteMoyenne;

    public static SerieDto convertEntitytoDto(SerieEntity serieEntity) {
        return SerieDto.builder()
            .id(serieEntity.getId())
            .nom(serieEntity.getNom())
            .description(serieEntity.getDescription())
            .dateSortie(serieEntity.getDateSortie())
            .noteMoyenne(CommentaireService.getMoyenne(serieEntity.getCommentaires()))
            .commentaires(serieEntity.getCommentaires().stream().map(
                commentaire -> CommentaireDto.convertEntitytoDto(commentaire)).toList()
            )
            .build();
    }

}
