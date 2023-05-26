import { Adresse } from './adresse';

export class Fournisseur {
  constructor(
    public nom?: string,
    public contact?: string,
    public adresse?: Adresse,
    public id?: number
  ) {}
}
