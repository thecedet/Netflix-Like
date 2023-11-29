import { Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { DetailPageComponent } from './pages/detail-page/detail-page.component';

export const routes: Routes = [
    {path: '', component: HomePageComponent},
    {path: 'series/:id', component: DetailPageComponent}
];
