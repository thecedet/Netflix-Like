import { Component } from '@angular/core';
import { ActeurFormComponent } from "./acteur-form/acteur-form.component";
import { ActeurListComponent } from "./acteur-list/acteur-list.component";
import { IActeur } from '../../models/acteur.models';
import { ActeurService } from '../../services/acteur.service';

@Component({
    selector: 'app-acteur-page',
    standalone: true,
    templateUrl: './acteur-page.component.html',
    styleUrl: './acteur-page.component.css',
    imports: [ActeurFormComponent, ActeurListComponent]
})
export class ActeurPageComponent {

    public acteurs : IActeur[] = [];

    constructor(private readonly acteurService : ActeurService) {}

    ngOnInit() : void {
        this.getActeurs();
    }

    private getActeurs() {
        this.acteurService.getActeurs().subscribe(acteurs => {
            this.acteurs = acteurs;
            acteurs.forEach(acteur => this.getImage(acteur))
        });
    }

    private getImage(acteur : IActeur) {
        this.acteurService.getPresignedUrl(acteur.id).subscribe(message => {
            if(message.code === 'GET_IMAGE_URL') acteur.image = message.message;
        })
    }

}
