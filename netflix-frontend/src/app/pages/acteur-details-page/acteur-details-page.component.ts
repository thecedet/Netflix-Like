import { Component, ViewChild } from '@angular/core';
import { ActeurDetailsFormComponent } from "./acteur-details-form/acteur-details-form.component";
import { ActeurService } from '../../services/acteur.service';
import { ActivatedRoute, Router } from '@angular/router';
import { IActeur, IActeurUpdate } from '../../models/acteur.models';
import { Observable } from 'rxjs';
import { NotificationService } from '../../services/notification.service';
import { InputFileComponent } from "../../components/input-file/input-file.component";
import { ActeurDetailsImageComponent } from "./acteur-details-image/acteur-details-image.component";
import { IMessage } from '../../models/message.models';

@Component({
    selector: 'app-acteur-details-page',
    standalone: true,
    templateUrl: './acteur-details-page.component.html',
    styleUrl: './acteur-details-page.component.css',
    imports: [ActeurDetailsFormComponent, InputFileComponent, ActeurDetailsImageComponent]
})
export class ActeurDetailsPageComponent {

    private id : string = this.activatedRoute.snapshot.params["id"]
    @ViewChild(ActeurDetailsFormComponent)
    private acteurForm ?: ActeurDetailsFormComponent;
    @ViewChild(ActeurDetailsImageComponent)
    private imageComponent ?: ActeurDetailsImageComponent;

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
        this.acteurService.getActeur(id).subscribe((acteur : IActeur) => {
            if(this.acteurForm) this.acteurForm.acteur = acteur;
            this.getImage()
        }, () => this.router.navigate([`404`]))
    }

    public updateActeur(acteur : IActeurUpdate) {
        this.acteurService.updateActeur(this.id, acteur).subscribe({
            complete: () => this.ntfService.success("Update de l'acteur avec succès"),
            error: () => this.ntfService.error("Update de l'acteur avec erreur")
        })
    }

    private getImage() : void {
        this.acteurService.getPresignedUrl(Number(this.id)).subscribe((message : IMessage) => {
            if(!this.imageComponent) return
            this.imageComponent.image = message;
        })
    }

    public uploadImage(file : File) : void {
        this.acteurService.uploadImage(this.id, file).subscribe((response : IMessage) => {
            if(response === null) {
                this.ntfService.success("upload succès")
                this.getImage()
                if(this.imageComponent) this.imageComponent.image = response;
            }else this.ntfService.error("Impossible d'upload l'image")
        })
    }

}
