import { Component } from '@angular/core';
import { SerieService } from '../../services/serie.service';
import { ISerie } from '../../models/serie.models';
import { ActivatedRoute, Router } from '@angular/router';
import { NotificationService } from '../../services/notification.service';
import { CommonModule } from '@angular/common';
import { CommentaireTableComponent } from "./commentaire-table/commentaire-table.component";
import { CommentaireFormComponent } from "./commentaire-form/commentaire-form.component";
import { ListElementsComponent } from "../../components/list-elements/list-elements.component";
import { IActeur } from '../../models/acteur.models';
import { ActeurService } from '../../services/acteur.service';
import { ImageComponent } from "../../components/image/image.component";
import { IMessage } from '../../models/message.models';
import { ActeurFormComponent } from "./acteur-form/acteur-form.component";

@Component({
    selector: 'app-serie-details-page',
    standalone: true,
    templateUrl: './serie-details-page.component.html',
    styleUrl: './serie-details-page.component.css',
    imports: [CommonModule, CommentaireTableComponent, CommentaireFormComponent, ListElementsComponent, ImageComponent, ActeurFormComponent]
})
export class SerieDetailsPageComponent {

  public serie ?: ISerie;
  public image?: IMessage;

  private id : string = this.activatedRoute.snapshot.params["id"]

  constructor(
    private readonly serieService : SerieService,
    private readonly acteurServie : ActeurService,
    private readonly activatedRoute : ActivatedRoute,
    private readonly ntfService : NotificationService,
    private readonly router : Router
  ) {}

  ngOnInit() : void {
    this.serieService.getSerie(this.id).subscribe({
        next: serie => {
            this.serie = serie;
            this.serie.acteurs.forEach(acteur => this.getImageActeur(acteur))
            this.getImageSerie(serie)
        },
        error: () => this.router.navigate(['404'])
    })
  }

  private getImageSerie(element : ISerie) : void {
    this.serieService.getPresignedUrl(element.id).subscribe({
        next: message => this.image = message
    })
  }

  private getImageActeur(element : IActeur) : void {
    this.acteurServie.getPresignedUrl(element.id).subscribe({
        next: message => element.image = message.message
    })
  }

  public uploadImage(file : File) : void {
    this.serieService.uploadImage(this.id, file).subscribe((response : IMessage) => {
        if(response === null) {
            this.ntfService.success("upload succès")
            if(this.serie) this.getImageSerie(this.serie)
            this.image = response;
        }else this.ntfService.error("Impossible d'upload l'image")
    })
}

}
