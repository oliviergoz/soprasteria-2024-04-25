import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.css'],
})
export class ProduitDetailComponent implements OnInit {
  nomProduit!: string;

  constructor(private activatedRoute: ActivatedRoute, private router: Router) {
    console.log('construction ProduitDetailComponent');
  }

  ngOnInit(): void {
    //this.nomProduit = this.activatedRoute.snapshot.params['id'];
    console.log('ngOnInit');
    this.activatedRoute.params.subscribe((params) => {
      this.nomProduit = params['id'];
    });
  }

  save() {
    //traitement sur les donnees du formulaire
    //controles
    //si tous les controles sont ok=>requete create ou update
    //on quitte la page quand le traitment est fini

    this.router.navigateByUrl('/home');
  }
}
