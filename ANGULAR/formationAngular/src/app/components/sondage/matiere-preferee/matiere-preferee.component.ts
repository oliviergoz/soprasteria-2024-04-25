import { Component } from '@angular/core';

@Component({
  selector: 'app-matiere-preferee',
  templateUrl: './matiere-preferee.component.html',
  styleUrls: ['./matiere-preferee.component.css'],
})
export class MatierePrefereeComponent {
  matierePreferee = '';
  vote = 0;

  getVote(obj: any) {
    if (obj.vote > this.vote) {
      this.vote = obj.vote;
      this.matierePreferee = obj.nom;
    }
  }
}
