import { Routes } from '@angular/router';
import { ActeurPageComponent } from './pages/acteur-page/acteur-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ActeurDetailsPageComponent } from './pages/acteur-details-page/acteur-details-page.component';
import { NotfoundPageComponent } from './pages/notfound-page/notfound-page.component';

export const routes: Routes = [
    {path: "", component: HomePageComponent},
    {path: "acteurs", component: ActeurPageComponent},
    {path: "acteurs/:id", component: ActeurDetailsPageComponent},
    {path: "404", component: NotfoundPageComponent},
    {path: "**", redirectTo: "/404"}
];
