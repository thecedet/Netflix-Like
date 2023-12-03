import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import { IActeur, IActeurCreate, IActeurUpdate } from '../models/acteur.models';
import { IMessage } from '../models/message.models';

@Injectable({
  providedIn: 'root'
})
export class ActeurService {

  constructor(private httpClient: HttpClient) { }

  private baseURL : string = "http://localhost:8080/acteurs"

  public getActeurs() : Observable<IActeur[]> {
    return this.httpClient.get<IActeur[]>(this.baseURL);
  }

  public getActeur(id : string) : Observable<IActeur> {
    return this.httpClient.get<IActeur>(`${this.baseURL}/${id}`);
  }

  public getPresignedUrl(id: number): Observable<IMessage> {
    return this.httpClient.get<IMessage>(`${this.baseURL}/${id}/image`).pipe(
        catchError(error => of(error.error))
    );
  }

  public createActeur(acteur : IActeurCreate) : Observable<IActeur> {
    return this.httpClient.post<IActeur>(this.baseURL, acteur);
  }

  public updateActeur(id : string, acteur: IActeurUpdate) : Observable<IActeur> {
    return this.httpClient.put<IActeur>(`${this.baseURL}/${id}`, acteur);
  }

}
