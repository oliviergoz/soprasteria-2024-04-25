import { Fournisseur } from './fournisseur';

export class Produit {
  constructor(
    public nom?: string,
    public description?: string,
    public prix?: number,
    public fournisseur?: Fournisseur,
    public id?: number
  ) {}
}
