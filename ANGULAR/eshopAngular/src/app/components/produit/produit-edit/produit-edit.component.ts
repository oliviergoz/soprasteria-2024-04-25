import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Fournisseur } from 'src/app/model/fournisseur';
import { Produit } from 'src/app/model/produit';
import { FournisseurService } from 'src/app/services/fournisseur.service';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-produit-edit',
  templateUrl: './produit-edit.component.html',
  styleUrls: ['./produit-edit.component.css'],
})
export class ProduitEditComponent implements OnInit {
  obsFournisseurs!: Observable<Fournisseur[]>;

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.produitSrv.getById(params['id']).subscribe((produitJson) => {
          this.produit = produitJson;
        });
      }
    });
    this.obsFournisseurs = this.fournisseurSrv.getFournisseurs();
  }

  produit: Produit = new Produit();

  constructor(
    private produitSrv: ProduitService,
    private fournisseurSrv: FournisseurService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  save() {
    if (this.produit.id) {
      this.produitSrv.update(this.produit).subscribe(() => {
        this.router.navigate(['/produit']);
      });
    } else {
      this.produitSrv.create(this.produit).subscribe((produitCree) => {
        this.router.navigateByUrl('/produit');
      });
    }
  }

  compareById(frsOptionActive: Fournisseur, frsSelect: Fournisseur): boolean {
    if (frsSelect && frsOptionActive) {
      return frsOptionActive.id === frsSelect.id;
    }
    return false;
  }
}
