import { Component, OnInit } from '@angular/core';
import { SelectMultipleControlValueAccessor } from '@angular/forms';
import { Player } from 'src/app/models/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  players: Player[] = [];

  selected: null | Player = null;

  newPlayer : Player = new Player;

  editPlayer : null | Player = null;

  addView : boolean = true;

  editView: boolean = false;

  tableView: boolean = false;

  detailView:boolean = true;


  constructor(private playerService: PlayerService) {

   }

   loadPlayers(){
    this.playerService.index().subscribe({
      next: (players: Player[]) => {
        console.log(players);
        this.players = players;
      },
      error: (oops) => {
        console.error('home.loadPlayers: error getting players');
        console.error(oops);
      }
    });
   }

   addPlayer(player: Player){
    this.playerService.create(player).subscribe({
      next: (created) => {
        this.loadPlayers();
        this.newPlayer = new Player();
      },
      error: (fail) => {
        console.error('home.addExercise: could not create');
        console.error(fail);
      },
    });
  }



   deletePlayer(playerId =0){
    this.playerService.destroy(playerId).subscribe({
      next: (success) => {
        this.loadPlayers();
      },
      error: (err) => {
        console.error('home.deleteExercise: could not delete');
        console.error(err);
      },
    });
  }


   displayPlayer(player: Player)
  {
     this.selected = player;
     this.addView = false;
    this.tableView = false;
    this.editView = false;
    this.detailView = true;
  }

  displayTable()
  {
    this.addView = false;
    this.tableView = true;
    this.editView = false;
    this.detailView = false;
  }

  addPlayerForm()
  {
    this.addView = true;
    this.tableView = false;
    this.editView = false;
    this.detailView = false;
  }
  editPlayerForm()
  {
    this.addView = false;
    this.tableView = true;
    this.editView = true;
    this.detailView = false;
  }


  setEditPlayer() {
    this.editPlayer = Object.assign({}, this.selected);
  }

  updatePlayer(player: Player, goToDetail = true): void {

    this.playerService.update(player).subscribe({
      next: (updated) => {
        if (goToDetail) {
          this.selected = updated;
        }
        this.loadPlayers();
        this.editPlayer = null;
      },
      error: (err) => {
        console.error('playerHttp.updatePlayer() error updating Player');
        console.error(err);
      },
    });
  }


  ngOnInit(): void {
    this.loadPlayers();
  }

}

