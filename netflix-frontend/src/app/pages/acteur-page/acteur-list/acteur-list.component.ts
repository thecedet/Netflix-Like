import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { IActeur } from '../../../models/acteur.models';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-acteur-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './acteur-list.component.html',
  styleUrl: './acteur-list.component.css'
})
export class ActeurListComponent {

  @Input() public acteurs: IActeur[] = [];

  constructor(private readonly router: Router) {}

  navigateToDetails(id : number) {
    this.router.navigate([`acteurs/${id}`])
  }

}
