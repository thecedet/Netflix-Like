import { Component, ViewChild } from '@angular/core';
import { ActeurDetailsFormComponent } from "./acteur-details-form/acteur-details-form.component";
import { ActeurService } from '../../services/acteur.service';
import { ActivatedRoute, Router } from '@angular/router';
import { IActeur, IActeurUpdate } from '../../models/acteur.models';
import { Observable } from 'rxjs';
import { NotificationService } from '../../services/notification.service';

@Component({
    selector: 'app-acteur-details-page',
    standalone: true,
    templateUrl: './acteur-details-page.component.html',
    styleUrl: './acteur-details-page.component.css',
    imports: [ActeurDetailsFormComponent]
})
export class ActeurDetailsPageComponent {

    private id : string = this.activatedRoute.snapshot.params["id"]
    @ViewChild(ActeurDetailsFormComponent)
    private acteurForm ?: ActeurDetailsFormComponent;

    constructor(
        private readonly acteurService : ActeurService,
        private readonly activatedRoute : ActivatedRoute,
        private readonly ntfService : NotificationService,
        private readonly router : Router
    ) {}

    ngOnInit() : void {
        this.getActeur(this.id);
    }

    private getActeur(id : string) : void {
        this.acteurService.getActeur(id).subscribe((value : IActeur) => {
            if(this.acteurForm) this.acteurForm.acteur = value;
        }, () => this.router.navigate([`404`]))
    }

    public updateActeur(acteur : IActeurUpdate) {
        this.acteurService.updateActeur(this.id, acteur).subscribe({
            complete: () => this.ntfService.success("Update de l'acteur avec succès"),
            error: () => this.ntfService.error("Update de l'acteur avec erreur")
        })
    }

}
