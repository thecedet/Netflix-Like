import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { IActeur } from '../../../models/acteur.models';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../../services/notification.service';

@Component({
  selector: 'app-acteur-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './acteur-list.component.html',
  styleUrl: './acteur-list.component.css'
})
export class ActeurListComponent {

  @Input() public acteurs: IActeur[] = [];

  constructor(
    private readonly router: Router,
    private readonly ntfService : NotificationService   
  ) {}

  public navigateToDetails(id : number) : void {
    this.router.navigate([`acteurs/${id}`])
  }

  public onErrorImage() : void {
    this.ntfService.error("Impossible de charger les images")
  }

}
