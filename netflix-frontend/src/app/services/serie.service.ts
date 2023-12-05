import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, mergeMap, of } from 'rxjs';
import { ISerie, ISerieCreate, ISerieUpdate } from '../models/serie.models';
import { IMessage } from '../models/message.models';

@Injectable({
  providedIn: 'root'
})
export class SerieService {

  constructor(
    private readonly httpClient : HttpClient
  ) { }

  private baseURL : string = "http://localhost:8080/series"

  public getSeries() : Observable<ISerie[]> {
    return this.httpClient.get<ISerie[]>(this.baseURL);
  }

  public getSerie(id : string) : Observable<ISerie> {
    return this.httpClient.get<ISerie>(`${this.baseURL}/${id}`);
  }

  public getPresignedUrl(id: number): Observable<IMessage> {
    return this.httpClient.get<IMessage>(`${this.baseURL}/${id}/image`).pipe(
        catchError(error => of(error.error))
    );
  }

  public createSerie(serie : ISerieCreate) : Observable<ISerie> {
    return this.httpClient.post<ISerie>(this.baseURL, serie);
  }

  public updateSerie(id : string, serie: ISerieUpdate) : Observable<ISerie> {
    return this.httpClient.put<ISerie>(`${this.baseURL}/${id}`, serie);
  }

  public uploadImage(id: string, file: File) : Observable<IMessage> {
    return this.httpClient.put<IMessage>(`${this.baseURL}/${id}/image`, {}).pipe(
      mergeMap((response : IMessage) => {
        return this.httpClient.put<IMessage>(response.message, file)
      }), catchError(error => of(error.error))
    );
  }
}
