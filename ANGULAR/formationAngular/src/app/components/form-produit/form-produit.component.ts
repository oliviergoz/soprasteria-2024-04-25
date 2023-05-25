import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-form-produit',
  templateUrl: './form-produit.component.html',
  styleUrls: ['./form-produit.component.css'],
})
export class FormProduitComponent {
  nom: string = '';
  prix: number = 0;

  @Output()
  //any=>json
  produitReady: EventEmitter<any> = new EventEmitter();

  send() {
    this.produitReady.emit({
      nom: this.nom,
      prix: this.prix,
    });
    this.nom = '';
    this.prix = 0;
  }
}
