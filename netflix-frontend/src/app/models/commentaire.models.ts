export interface ICommentaire {
    id: number,
    auteur: string,
    note: number,
    commentaire: string
}

export interface ICommentaireCreate {
    auteur: string,
    note: number,
    commentaire: string
}

export interface ICommentaireUpdate {
    auteur?: string,
    note?: number,
    commentaire?: string
}