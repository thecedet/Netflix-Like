package fr.polytech.netflixbackend.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.polytech.netflixbackend.entity.SerieEntity;
import fr.polytech.netflixbackend.helper.CalculMoyenne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SerieSommaireDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date_sortie")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateSortie;

    @JsonProperty("note_moyenne")
    private float noteMoyenne;

    public static SerieSommaireDto convertEntitytoDto(final SerieEntity serieEntity) {
        return SerieSommaireDto.builder()
            .id(serieEntity.getId())
            .nom(serieEntity.getNom())
            .description(serieEntity.getDescription())
            .dateSortie(serieEntity.getDateSortie())
            .noteMoyenne(CalculMoyenne.getMoyenne(serieEntity.getCommentaires()))
            .build();
    }

}
