import { Component, Input } from '@angular/core';
import { Produit } from 'src/app/models/produit';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent {
  produit: Produit = new Produit();

  getProduit(produitJson: any): void {
    //this.produit = new Produit(produitJson.nom, produitJson.prix);
    console.debug('le produit avant recuperation');
    console.debug(this.produit);
    this.produit = produitJson;
    console.debug('produit apres recuperation');
    console.debug(this.produit);
  }
}
