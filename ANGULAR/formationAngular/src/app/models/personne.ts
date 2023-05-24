export class Personne {
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  // //attributs
  // private prenom: string | undefined;
  // private nom: string | undefined;
  // //construteur
  // constructor(prenom?: string, nom?: string) {
  //   this.prenom = prenom;
  //   this.nom = nom;
  // }

  // //methodes

  constructor(private _prenom?: string, private _nom?: string) {}

  sePresenter(): string {
    return this.prenom + ' ' + this.nom;
  }

  get prenom(): string | undefined {
    return this._prenom;
  }

  set prenom(value: string | undefined) {
    this._prenom = value;
  }
}
