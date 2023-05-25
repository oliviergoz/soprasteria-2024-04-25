import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.css'],
})
export class ProduitDetailComponent implements OnInit {
  nomProduit!: string;

  constructor(private activatedRoute: ActivatedRoute) {}
  ngOnInit(): void {
    this.nomProduit = this.activatedRoute.snapshot.params['id'];
  }
}
