import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output, Input } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { IActeur, IActeurUpdate } from '../../../models/acteur.models';
import { InputFileComponent } from '../../../components/input-file/input-file.component';

@Component({
  selector: 'app-acteur-details-form',
  standalone: true,
  imports: [CommonModule, FormsModule, InputFileComponent],
  templateUrl: './acteur-details-form.component.html',
  styleUrl: './acteur-details-form.component.css'
})
export class ActeurDetailsFormComponent {

  @Input() set acteur(value: IActeur | undefined) {
    this.acteurUpdate = {
      nom: value?.nom || "",
      prenom: value?.prenom || ""
    }
 }

  public acteurUpdate : IActeurUpdate = {
    nom: "",
    prenom: ""
  }

  @Output() public updateActeur : EventEmitter<IActeurUpdate> = new EventEmitter();

  public submit(form: NgForm) : void {
    if(form.valid) this.updateActeur.emit(this.acteurUpdate)
  }

}
