package fr.polytech.netflixbackend.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    @ManyToMany(mappedBy = "acteurs")
    private List<SerieEntity> series;

}
