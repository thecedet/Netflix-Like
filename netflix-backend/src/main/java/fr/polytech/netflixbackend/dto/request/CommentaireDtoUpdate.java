package fr.polytech.netflixbackend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentaireDtoUpdate {

    @JsonProperty(value = "auteur", required = false)
    @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
    private String auteur;
    
    @JsonProperty(value = "note", required = false)
    @Min(0)
    @Max(5)
    private Integer note;
    
    @JsonProperty(value = "commentaire", required = false)
    @Size(max = 255, message = "Le commentaire ne doit pas dépasser 255 caractères")
    private String commentaire;
    
    @JsonProperty(value = "screenshot", required = false)
    private String screenshot;
}
