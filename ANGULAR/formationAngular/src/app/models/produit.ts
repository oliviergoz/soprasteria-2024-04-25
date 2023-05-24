export class Produit {
  public get prix(): number | undefined {
    return this._prix;
  }
  public set prix(value: number | undefined) {
    this._prix = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  constructor(private _nom?: string, private _prix?: number) {}
}
