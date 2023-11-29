export interface SerieDto {
    id: number;
    nom: string;
    description: string;
    date_sortie: string;
    evaluations?: CommentaireDto[];
    note_moyenne: number;
}

export interface CommentaireDto {
    id: number;
    nom: string;
    note: number;
    commentaire: string;
}