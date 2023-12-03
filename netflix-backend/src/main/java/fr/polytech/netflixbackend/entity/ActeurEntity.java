package fr.polytech.netflixbackend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity(name = "acteurs")
@NoArgsConstructor
@AllArgsConstructor
public class ActeurEntity {
    
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(
        name = "nom",
        columnDefinition = "varchar(50)",
        nullable=false
    )
    private String nom;

    @Column(
        name = "prenom",
        columnDefinition = "varchar(50)",
        nullable=false
    )
    private String prenom;

    @Column(
        name = "image",
        columnDefinition = "boolean",
        nullable = true
    )
    private boolean image;

    @ManyToMany(mappedBy = "acteurs")
    private List<SerieEntity> series;

}
