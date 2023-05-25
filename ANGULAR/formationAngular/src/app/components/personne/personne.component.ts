import { Component } from '@angular/core';
import { Personne } from 'src/app/models/personne';

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css'],
})
export class PersonneComponent {
  personnes: Personne[] = [
    new Personne('olivier', 'gozlan'),
    new Personne('jordan', 'abid'),
  ];

  recuperationPersonne(personne: Personne) {
    this.personnes.push(personne);
  }
}
