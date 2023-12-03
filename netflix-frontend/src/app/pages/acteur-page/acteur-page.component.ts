import { Component } from '@angular/core';
import { ActeurFormComponent } from "./acteur-form/acteur-form.component";
import { ActeurListComponent } from "./acteur-list/acteur-list.component";

@Component({
    selector: 'app-acteur-page',
    standalone: true,
    templateUrl: './acteur-page.component.html',
    styleUrl: './acteur-page.component.css',
    imports: [ActeurFormComponent, ActeurListComponent]
})
export class ActeurPageComponent {

}
