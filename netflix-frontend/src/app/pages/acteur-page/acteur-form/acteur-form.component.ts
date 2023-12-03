import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { IActeurCreate } from '../../../models/acteur.models';

@Component({
    selector: 'app-acteur-form',
    standalone: true,
    templateUrl: './acteur-form.component.html',
    styleUrl: './acteur-form.component.css',
    imports: [CommonModule, FormsModule]
})
export class ActeurFormComponent {

  public acteur : IActeurCreate = {
    nom: "",
    prenom: ""
  }

  @Output() public createActeur : EventEmitter<IActeurCreate> = new EventEmitter();

  constructor() {}

  public submit(form : NgForm) : void {
    if(form.valid) this.createActeur.emit(this.acteur)
  }

}
