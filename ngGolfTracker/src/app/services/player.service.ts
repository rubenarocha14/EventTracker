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

    show(playerId: number): Observable<Player>{
      return this.http.get<Player>(this.url + '/' + playerId).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error('PlayerService.show(): error retrieving player: ' + err)
          );
        })
      );
    }

    create(newPlayer: Player){
      return this.http.post<Player>(this.url, newPlayer).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error('PlayerService.create(): error retrieving player: ' + err)
          );
        })
      )
    }

    update(player: Player){
      return this.http.put<Player>(this.url +'/' + player.id, player).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error('PlayerService.update(): error retrieving player: ' + err)
          );
        })
      )
    }

    destroy(playerId: number): Observable<void>{
      return this.http.delete<void>(this.url + '/' + playerId).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error('PlayerService.show(): error retrieving player: ' + err)
          );
        })
      )
    }
}
