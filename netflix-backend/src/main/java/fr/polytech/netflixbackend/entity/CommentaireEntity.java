package fr.polytech.netflixbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity(name = "commentaires")
@NoArgsConstructor
@AllArgsConstructor
public class CommentaireEntity {
    
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(
        name = "auteur",
        columnDefinition = "varchar(50)",
        nullable=false
    )
    private String auteur;

    @Column(
        name = "note",
        columnDefinition = "int",
        nullable = false
    )
    private Integer note;

    @Column(
        name = "commentaire",
        columnDefinition = "varchar(255)",
        nullable = false
    )
    private String commentaire;

    @Column(
        name = "screenshot",
        nullable = true,
        columnDefinition = "boolean"
    )
    private boolean screenshot;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private SerieEntity serie;

}
