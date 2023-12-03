package fr.polytech.netflixbackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.polytech.netflixbackend.entity.ActeurEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActeurDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    public static ActeurDto convertEntitytoDto(final ActeurEntity acteurEntity) {
        return ActeurDto.builder()
            .id(acteurEntity.getId())
            .nom(acteurEntity.getNom())
            .prenom(acteurEntity.getPrenom())
            .build();
    }

}
