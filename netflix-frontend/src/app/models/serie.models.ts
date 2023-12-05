import { IActeur } from "./acteur.models"
import { ICommentaire } from "./commentaire.models"

export interface ISerie {
    id: number,
    nom: string,
    description: string,
    date_sortie: Date,
    commentaires: ICommentaire[],
    acteurs: IActeur[],
    note_moyenne: number,
    image?: string
}

export interface ISerieSummary {
    id: number,
    nom: string,
    description: string,
    image?: string,
    date_sortie: Date,
    note_moyenne: number
}

export interface ISerieCreate {
    nom: string,
    description: string,
    date_sortie: Date
}

export interface ISerieUpdate {
    nom?: string,
    description?: string,
    image?: string,
    date_sortie?: Date
}