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
public class ActeurDtoUpdate {

    @JsonProperty(value = "nom", required = false)
    private String nom;

    @JsonProperty(value = "prenom", required = false)
    private String prenom;

}
