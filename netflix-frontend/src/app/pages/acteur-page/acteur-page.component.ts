import { Component, ViewChild } from '@angular/core';
import { ActeurFormComponent } from "./acteur-form/acteur-form.component";
import { ActeurListComponent } from "./acteur-list/acteur-list.component";
import { IActeur, IActeurCreate } from '../../models/acteur.models';
import { ActeurService } from '../../services/acteur.service';
import { NotificationService } from '../../services/notification.service';

@Component({
    selector: 'app-acteur-page',
    standalone: true,
    templateUrl: './acteur-page.component.html',
    styleUrl: './acteur-page.component.css',
    imports: [ActeurFormComponent, ActeurListComponent]
})
export class ActeurPageComponent {

    public acteurs : IActeur[] = [];

    @ViewChild(ActeurFormComponent)
    form?: ActeurFormComponent;

    constructor(
        private readonly acteurService : ActeurService,
        private readonly ntfService : NotificationService 
    ) {}

    ngOnInit() : void {
        this.getActeurs();
    }

    private getActeurs() : void {
        this.acteurService.getActeurs().subscribe(acteurs => {
            this.acteurs = acteurs;
            acteurs.forEach(acteur => this.getImage(acteur))
        });
    }

    private getImage(acteur : IActeur) : void {
        this.acteurService.getPresignedUrl(acteur.id).subscribe(message => {
            if(message.code === 'GET_IMAGE_URL') acteur.image = message.message;
        })
    }

    public createActeur(acteur: IActeurCreate) : void {
        this.acteurService.createActeur(acteur).subscribe(value => {
            this.acteurs.push(value);
            this.ntfService.success("Création de l'acteur avec succès")
            if(this.form) {
                this.form.acteur = {
                    prenom: "",
                    nom: ""
                } as IActeur
            }
        }, () => this.ntfService.error("Création de l'acteur avec erreur"))
    }

}
