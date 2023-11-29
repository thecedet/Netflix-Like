import {Injectable} from "@angular/core"
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { SerieDto } from "../models/serie.dto";

@Injectable({
    providedIn: 'root'
})
export class SerieService {
    constructor(private httpClient: HttpClient) {

    }

    public getSeries(): Observable<SerieDto[]> {
        return this.httpClient.get<SerieDto[]>(`http://localhost:8080/series`)
    }

}