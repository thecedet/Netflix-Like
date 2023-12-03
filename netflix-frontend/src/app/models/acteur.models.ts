export interface IActeurCreate {
    nom: string,
    prenom: string
}

export interface IActeurUpdate {
    nom: string,
    prenom: string,
    image?: string, 
}

export interface IActeur {
    id: number
    nom: string,
    prenom: string
    image?: string
}