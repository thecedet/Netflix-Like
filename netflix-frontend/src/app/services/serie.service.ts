import {Injectable} from "@angular/core"
import { HttpClient } from "@angular/common/http";
import { Observable, catchError, map, mergeMap, of } from "rxjs";
import { SerieDto } from "../models/serie.dto";
import { MessageDto } from '../models/message.dto';
import { SerieCreateDto } from "../models/serie.create.dto";

@Injectable({
    providedIn: 'root'
})
export class SerieService {
    
    constructor(private httpClient: HttpClient) {}

    private baseURL : string = "http://localhost:8080/series"

    public getSeries(): Observable<SerieDto[]> {
        return this.httpClient.get<SerieDto[]>(this.baseURL)
    }

    public getPresignedUrl(id: string): Observable<MessageDto> {
        return this.httpClient.get<MessageDto>(`${this.baseURL}/${id}/cover`).pipe(
            catchError(error => of(error.error))
        );
    }

    public createSerie(serie: SerieCreateDto) : Observable<SerieDto> {
        return this.httpClient.post<SerieDto>(this.baseURL, serie);
    }

    postImage(id: string, file: File) : Observable<MessageDto> {

        return this.httpClient.post<MessageDto>(`${this.baseURL}/${id}/cover`, {}).pipe(
            mergeMap((response: MessageDto) => {
                return this.httpClient.put<MessageDto>(response.message, file)  
            })
        )
    }

}