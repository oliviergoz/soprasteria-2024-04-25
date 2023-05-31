import { Adresse } from './adresse';

export class Client {
  constructor(
    public prenom?: string,
    public nom?: string,
    public adresse?: Adresse,
    public id?: number
  ) {}
}
