import { Component, Input, OnInit } from '@angular/core';
import { Personne } from 'src/app/models/personne';

@Component({
  selector: 'app-bonjour',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent implements OnInit {
  // @Input()
  // prenom!: string;
  // @Input()
  // nom!: string;
  // @Input('photo')
  // picture!: string;

  @Input()
  personne!: Personne;

  constructor() {}

  ngOnInit(): void {
    //garanti le traitement des inputs
  }
}
