import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormsModule, NgForm } from '@angular/forms';
import { SerieCreateDto } from '../../models/serie.create.dto';

@Component({
  selector: 'app-form-serie',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './form-serie.component.html',
  styleUrl: './form-serie.component.css'
})

export class FormSerieComponent {

  serie: SerieCreateDto = {
    "nom": "",
    "description": "",
    "date_sortie": ""
  };

  @Output()
  public createSerie : EventEmitter<SerieCreateDto> = new EventEmitter();

  constructor() {}

  public submit(form : NgForm) : void {
    if(form.valid) this.createSerie.emit(this.serie)
  }

}
