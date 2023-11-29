package fr.polytech.netflixbackend.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SerieDtoCreate {

    @JsonProperty("nom")
    @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
    @NotNull(message = "Paramètre manquant : nom")
    @NotBlank(message = "Paramètre manquant : nom")
    private String nom;

    @JsonProperty("description")
    @Size(max = 255, message = "La description ne doit pas dépasser 255 caractères")
    @NotNull(message = "Paramètre manquant : description")
    @NotBlank(message = "Paramètre manquant : description")
    private String description;

    @JsonProperty("date_sortie")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Paramètre manquant : date_sortie")
    private LocalDate dateSortie;

}
