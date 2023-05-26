import { Component, OnInit } from '@angular/core';
import { Fournisseur } from 'src/app/model/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-fournisseur-list',
  templateUrl: './fournisseur-list.component.html',
  styleUrls: ['./fournisseur-list.component.css'],
})
export class FournisseurListComponent implements OnInit {
  fournisseurs!: Fournisseur[];

  constructor(private fournisseurSrv: FournisseurService) {}

  ngOnInit(): void {
    this.listFournisseurs();
  }

  listFournisseurs() {
    this.fournisseurSrv.getFournisseurs().subscribe((resultat) => {
      this.fournisseurs = resultat;
    });
  }

  deleteFournisseur(id: number) {
    this.fournisseurSrv.deleteById(id).subscribe(() => {
      this.listFournisseurs();
    });
  }
}
