import { Component } from '@angular/core';
import { SerieFormComponent } from "./serie-form/serie-form.component";
import { ISerie, ISerieCreate, ISerieSummary } from '../../models/serie.models';
import { SerieTableComponent } from "./serie-table/serie-table.component";
import { SerieService } from '../../services/serie.service';
import { NotificationService } from '../../services/notification.service';

@Component({
    selector: 'app-serie-page',
    standalone: true,
    templateUrl: './serie-page.component.html',
    styleUrl: './serie-page.component.css',
    imports: [SerieFormComponent, SerieTableComponent]
})
export class SeriePageComponent {

    public series : ISerieSummary[] = [];
    public serie  : ISerieCreate = {
        date_sortie: new Date(),
        description: "",
        nom: ""
    };

    constructor(
        private readonly serieService : SerieService,
        private readonly ntfService : NotificationService
    ) {}

    ngOnInit() : void {
        this.serieService.getSeries().subscribe({
            next: series => {
                this.series = series;
                series.forEach(serie => this.getImage(serie))
            },
            error: () => this.ntfService.error("Impossible de récupérer les séries")
        })
    }


    public create(serie: ISerieCreate) : void {
       this.serieService.createSerie(serie).subscribe({
        next: value => {
            this.series.push(value);
            this.ntfService.success("Création de la série avec succès")
        },
        error: () => this.ntfService.error("Création de la série avec erreur")
       })
    }

    private getImage(serie : ISerieSummary) : void {
        this.serieService.getPresignedUrl(serie.id).subscribe({
            next: message => {
                if(message.code === 'GET_IMAGE_URL') serie.image = message.message;
            }
        })
    }

    

}
