import { Component, EventEmitter, Output } from '@angular/core';
import { Personne } from 'src/app/models/personne';

@Component({
  selector: 'app-form-personne',
  templateUrl: './form-personne.component.html',
  styleUrls: ['./form-personne.component.css'],
})
export class FormPersonneComponent {
  personne = new Personne();

  @Output()
  personnePrete: EventEmitter<Personne> = new EventEmitter();
  //definition de l'evenement à traiter pour recuperer la donnée

  envoyer() {
    //declenchement de levenement
    this.personnePrete.emit(this.personne);
    this.personne = new Personne();
  }
}
