import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { IActeur, IActeurCreate } from '../../../models/acteur.models';

@Component({
    selector: 'app-acteur-form',
    standalone: true,
    templateUrl: './acteur-form.component.html',
    styleUrl: './acteur-form.component.css',
    imports: [CommonModule, FormsModule]
})
export class ActeurFormComponent {

  @Input() set acteur(value: IActeurCreate | undefined) {
    this.acteur = {
      nom: value?.nom || "",
      prenom: value?.prenom || ""
    }
  }

  public acteurUpdate : IActeurCreate = {
    nom: "",
    prenom: ""
  }

  @Output() public createActeur : EventEmitter<IActeurCreate> = new EventEmitter();

  constructor() {}

  public submit(form : NgForm) : void {
    if(form.valid) {
      this.createActeur.emit(this.acteurUpdate)
      form.reset(this.acteur)
    }
  }

}
