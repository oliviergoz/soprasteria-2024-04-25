import { Injectable } from '@angular/core';
import { Personne } from '../models/personne';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  constructor() {}

  public getPersonnes(): Personne[] {
    return [new Personne('olivier', 'gozlan'), new Personne('jordan', 'abid')];
  }
}
