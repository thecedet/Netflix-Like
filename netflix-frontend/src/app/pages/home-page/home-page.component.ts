import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SerieDto } from '../../models/serie.dto';
import { TableSerieComponent } from "../../components/table-serie/table-serie.component";
import { SerieService } from '../../services/serie.service';

@Component({
    selector: 'app-home-page',
    standalone: true,
    templateUrl: './home-page.component.html',
    styleUrl: './home-page.component.css',
    imports: [CommonModule, TableSerieComponent]
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

}
