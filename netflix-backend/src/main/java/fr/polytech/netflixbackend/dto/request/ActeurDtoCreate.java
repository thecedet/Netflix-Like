package fr.polytech.netflixbackend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActeurDtoCreate {

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

}