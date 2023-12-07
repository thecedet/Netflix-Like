import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { IActeur } from '../../models/acteur.models';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-list-elements',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list-elements.component.html',
  styleUrl: './list-elements.component.css'
})
export class ListElementsComponent {

  @Input() public items : any[] = [];
  @Input() public path  : string = "";

  constructor(
    private readonly router: Router,
    private readonly ntfService : NotificationService   
  ) {}

  public navigateToDetails(id : number) : void {
    this.router.navigate([`${this.path}/${id}`])
  }

  public onErrorImage() : void {
    this.ntfService.error("Impossible de charger les images")
  }

}
