import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SerieDto } from '../../models/serie.dto';
import { Router } from '@angular/router';
import { TableYellowOrRedDirective } from '../../directives/table-yellow-or-red.directive';

@Component({
  selector: 'app-table-serie',
  standalone: true,
  imports: [CommonModule, TableYellowOrRedDirective],
  templateUrl: './table-serie.component.html',
  styleUrl: './table-serie.component.css'
})

export class TableSerieComponent {

  navigateToDetails(id: number) {
    this.router.navigate([`series/${id}`])
  }

  @Input()
  public series: SerieDto[] = [];

  constructor(private readonly router: Router) {
  }
}
