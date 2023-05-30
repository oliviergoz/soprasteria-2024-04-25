import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from 'src/app/model/produit';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.css'],
})
export class ProduitListComponent implements OnInit {
  obsProduits!: Observable<Produit[]>;

  constructor(private produitSrv: ProduitService) {}

  ngOnInit(): void {
    this.obsProduits = this.produitSrv.getAll();
    // this.init();
  }
  // produits: Produit[] = [];

  // init() {
  //   this.produitSrv.getAll().subscribe((tabProduitJson) => {
  //     this.produits = tabProduitJson;
  //   });
  // }

  delete(id: number) {
    this.produitSrv.delete(id).subscribe(() => {
      this.obsProduits = this.produitSrv.getAll();
    });
  }
}
