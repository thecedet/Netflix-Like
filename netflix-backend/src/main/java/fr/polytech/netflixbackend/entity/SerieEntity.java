package fr.polytech.netflixbackend.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="series")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SerieEntity {
    
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(
        name = "nom",
        columnDefinition = "varchar(50)",
        nullable = false
    )
    private String nom;

    @Column(
        name = "description",
        columnDefinition = "varchar(255)",
        nullable = false
    )
    private String description;

    @Column(
        name = "jacquette",
        columnDefinition = "varchar(4)",
        nullable = true
    )
    private String jacquette;

    @Column(
        name = "dateSortie",
        columnDefinition = "date",
        nullable =  false
    )
    private LocalDate dateSortie;

    @OneToMany(
        mappedBy = "serie",
        cascade = CascadeType.ALL
    )
    private List<CommentaireEntity> commentaires;

    @ManyToMany
    @JoinTable(
        name = "serie_jn_acteur",
        joinColumns = @JoinColumn(name="id_acteur"),
        inverseJoinColumns = @JoinColumn(name="id_serie")
    )
    private List<ActeurEntity> acteurs;

}
