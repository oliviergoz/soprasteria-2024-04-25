import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.css'],
})
export class MatiereComponent {
  @Input()
  nom = '';
  vote = 0;

  @Output()
  voteEmitter: EventEmitter<any> = new EventEmitter<any>();

  voter() {
    this.vote++;
    this.voteEmitter.emit({
      nom: this.nom,
      vote: this.vote,
    });
  }
}
