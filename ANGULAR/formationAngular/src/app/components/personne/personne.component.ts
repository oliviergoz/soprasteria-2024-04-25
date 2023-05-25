import { Component } from '@angular/core';
import { Personne } from 'src/app/models/personne';

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css'],
})
export class PersonneComponent {
  personneAEnvoyer = new Personne();
  personnes: Personne[] = [];

  recuperationPersonne(personne: Personne) {
    this.personneAEnvoyer = personne;
  }
}
