import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SerieDto } from '../../models/serie.dto';
import { TableSerieComponent } from "../../components/table-serie/table-serie.component";
import { SerieService } from '../../services/serie.service';
import { FormSerieComponent } from "../../components/form-serie/form-serie.component";
import { SerieCreateDto } from '../../models/serie.create.dto';

@Component({
    selector: 'app-home-page',
    standalone: true,
    templateUrl: './home-page.component.html',
    styleUrl: './home-page.component.css',
    imports: [CommonModule, TableSerieComponent, FormSerieComponent]
})
export class HomePageComponent {

  public series : SerieDto[] = [];

  constructor(private serieService : SerieService) {
    
  }

    ngOnInit(): void {
        this.serieService.getSeries().subscribe({
            next: series => this.series = series
        })
    }

    public createSerie(serie: SerieCreateDto) : void {
        this.serieService.createSerie(serie).subscribe({
            next: value => this.series.push(value)
        });
    }

}
