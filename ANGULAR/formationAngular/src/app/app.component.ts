import { Component } from '@angular/core';
import { Personne } from './models/personne';
import { Produit } from './models/produit';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'formationAngular';

  produit = new Produit();

  monAlert() {
    this.produit = new Produit('ordinateur', 500);
  }
}
