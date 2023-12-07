import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output, Input } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { ISerie, ISerieCreate } from '../../../models/serie.models';

@Component({
  selector: 'app-serie-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './serie-form.component.html',
  styleUrl: './serie-form.component.css'
})
export class SerieFormComponent {


  @Input() public serie ?: ISerieCreate;

  @Output() public create : EventEmitter<ISerieCreate> = new EventEmitter();

  public submit(form : NgForm) : void {
    if(form.valid) {
      this.create.emit(this.serie)
      form.reset(this.serie)
    }
  }

}
