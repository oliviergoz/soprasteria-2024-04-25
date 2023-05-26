import { Component } from '@angular/core';
import { Personne } from 'src/app/models/personne';
import { DemoService } from 'src/app/services/demo.service';

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css'],
})
export class PersonneComponent {
  personnes: Personne[];

  constructor(private demoSrv: DemoService) {
    this.personnes = demoSrv.getPersonnes();
  }

  recuperationPersonne(personne: Personne) {
    this.personnes.push(personne);
  }
}
