import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Adresse } from 'src/app/model/adresse';
import { Fournisseur } from 'src/app/model/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-fournisseur-edit',
  templateUrl: './fournisseur-edit.component.html',
  styleUrls: ['./fournisseur-edit.component.css'],
})
export class FournisseurEditComponent implements OnInit {
  fournisseur!: Fournisseur;

  constructor(
    private fournisseurSrv: FournisseurService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    let adresse: Adresse = new Adresse();
    this.fournisseur = new Fournisseur();
    this.fournisseur.adresse = adresse;
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.fournisseurSrv.getById(params['id']).subscribe((res) => {
          this.fournisseur = res;
        });
      }
    });
  }

  save() {
    if (this.fournisseur.id) {
      this.fournisseurSrv.update(this.fournisseur).subscribe((res) => {
        this.router.navigateByUrl('/fournisseur');
      });
    } else {
      this.fournisseurSrv.create(this.fournisseur).subscribe((res) => {
        this.router.navigateByUrl('/fournisseur');
      });
    }
  }
}
