import { Component, Input } from '@angular/core';
import { Produit } from 'src/app/models/produit';

@Component({
  selector: 'app-display-produit',
  templateUrl: './display-produit.component.html',
  styleUrls: ['./display-produit.component.css'],
})
export class DisplayProduitComponent {
  @Input()
  produit: Produit = new Produit();
}
