import { Component, Input } from '@angular/core';
import { Produit } from 'src/app/models/produit';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent {
  @Input()
  produit = new Produit();
}
