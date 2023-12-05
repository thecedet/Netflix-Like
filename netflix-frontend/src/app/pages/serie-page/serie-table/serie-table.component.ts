import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { TableSetColorDirective } from '../../../directives/table-set-color.directive';
import { Router } from '@angular/router';
import { ISerieSummary } from '../../../models/serie.models';
import { NotificationService } from '../../../services/notification.service';
import { SerieService } from '../../../services/serie.service';

@Component({
  selector: 'app-serie-table',
  standalone: true,
  imports: [CommonModule, TableSetColorDirective],
  templateUrl: './serie-table.component.html',
  styleUrl: './serie-table.component.css'
})
export class SerieTableComponent {

  constructor(
    private readonly router: Router,
    private readonly ntfService : NotificationService
  ) {}

  navigateToDetails(id: number) {
    this.router.navigate([`series/${id}`])
  }

  @Input() public series: ISerieSummary[] = [];

  public onErrorImage() : void {
    this.ntfService.error("Impossible de charger les images")
  }

}
