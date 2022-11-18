import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Player } from '../models/player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  baseUrl = 'http://localhost:8084/';
  url = this.baseUrl + 'api/players';

  constructor(private http: HttpClient) {

   }

   index(): Observable<Player[]>{
    return this.http.get<Player[]>(this.url).pipe(
      catchError((err: any)=>{
        console.log(err);
        return throwError(
          () => new Error('PlayerService.index(): error retrieving data')
        );
      })
    )
    }
}
