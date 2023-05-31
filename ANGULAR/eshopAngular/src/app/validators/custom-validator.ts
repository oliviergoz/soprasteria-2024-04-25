import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class CustomValidator {
  public static pasToto(control: AbstractControl): null | ValidationErrors {
    return control.value == 'toto' ? { toto: true } : null;
  }

  public static pasChaineDefinieParLUtilisateur(chaine: string): ValidatorFn {
    return (control: AbstractControl) => {
      return control.value == chaine ? { chaineInterdite: true } : null;
    };
  }
}
