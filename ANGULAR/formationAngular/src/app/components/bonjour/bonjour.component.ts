import { Component } from '@angular/core';
import { Personne } from 'src/app/models/personne';

@Component({
  selector: 'app-bonjour',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent {
  prenom: string = 'jordan';
  nom = 'abid';
  personne!: Personne;

  constructor() {
    this.initPersonne();
  }

  initPersonne() {
    this.personne = new Personne('John', 'Doe');
  }
}
