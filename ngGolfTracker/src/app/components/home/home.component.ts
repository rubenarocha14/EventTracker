import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/models/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  players: Player[] = [];

  constructor(private playerService: PlayerService) {

   }

   loadPlayers(){
    this.playerService.index().subscribe({
      next: (players: Player[]) => {
        console.log(players);
        this.players = players;
      },
      error: (oops) => {
        console.error('HomeComponent.loadPlayers: error getting players');
        console.error(oops);
      }
    });
   }

  ngOnInit(): void {
    this.loadPlayers();
  }

}
