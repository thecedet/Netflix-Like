package fr.polytech.netflixbackend.helper;

import java.util.List;

import fr.polytech.netflixbackend.entity.CommentaireEntity;

public class CalculMoyenne {
    
    public static float getMoyenne(List<CommentaireEntity> commentaires) {
        final Integer nbrCommentaire = commentaires.size();
        if(nbrCommentaire == 0) return 5;
        return commentaires.stream()
            .map(commentaire -> commentaire.getNote())
            .reduce(0, (notes, note) -> notes + note)
            /nbrCommentaire;
    }

}
