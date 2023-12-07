import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { IDropdownSettings, NgMultiSelectDropDownModule} from 'ng-multiselect-dropdown';

@Component({
  selector: 'app-acteur-form',
  standalone: true,
  imports: [CommonModule, NgMultiSelectDropDownModule],
  templateUrl: './acteur-form.component.html',
  styleUrl: './acteur-form.component.css'
})
export class ActeurFormComponent {

}
