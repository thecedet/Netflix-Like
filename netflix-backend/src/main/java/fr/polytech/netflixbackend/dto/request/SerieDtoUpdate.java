package fr.polytech.netflixbackend.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SerieDtoUpdate {

    @JsonProperty(value = "nom", required = false)
    @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
    private String nom;

    @JsonProperty(value = "description", required = false)
    @Size(max = 255, message = "La description ne doit pas dépasser 255 caractères")
    private String description;

    @JsonProperty(value = "date_sortie", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSortie;

}