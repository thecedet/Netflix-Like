import { Routes } from '@angular/router';
import { ActeurPageComponent } from './pages/acteur-page/acteur-page.component';

export const routes: Routes = [
    {path: "acteurs", component: ActeurPageComponent},
    {path: "acteurs/:id", component: ActeurPageComponent}
];
