import { Component } from '@angular/core';

@Component({
  selector: 'app-matiere-preferee',
  templateUrl: './matiere-preferee.component.html',
  styleUrls: ['./matiere-preferee.component.css'],
})
export class MatierePrefereeComponent {
  matierePreferee = '';
  vote = 0;
  matieres = ['java', 'uml', 'javascript', 'angular'];
  matiereAAjouter = '';

  getVote(obj: any) {
    if (obj.vote > this.vote) {
      this.vote = obj.vote;
      this.matierePreferee = obj.nom;
    }
  }

  ajoutMatiere() {
    if (this.matiereAAjouter) {
      this.matieres.push(this.matiereAAjouter);
      this.matiereAAjouter = '';
    }
  }
}
