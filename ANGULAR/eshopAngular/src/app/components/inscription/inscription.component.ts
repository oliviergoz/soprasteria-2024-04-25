import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, map } from 'rxjs';
import { ClientService } from 'src/app/services/client.service';
import { CustomValidator } from 'src/app/validators/custom-validator';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form!: FormGroup;

  constructor(private clientSrv: ClientService, private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl(
        '',
        [
          Validators.required,
          CustomValidator.pasToto,
          CustomValidator.pasChaineDefinieParLUtilisateur('tutu'),
        ],
        this.loginLibre()
      ),
      passwordGrp: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.pattern(
              /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%?&])[A-Za-z\d@$!%?&]{4,}$/
            ),
          ]),
          confirmPassword: new FormControl(),
        },
        this.controlsEgaux
      ),
      prenom: new FormControl('', Validators.required),
      nom: new FormControl('', Validators.required),
      numero: new FormControl(),
      rue: new FormControl(),
      codePostal: new FormControl(),
      ville: new FormControl('', Validators.required),
    });
  }

  loginLibre(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.clientSrv.loginExist(control.value).pipe(
        map((resultat: boolean) => {
          return resultat ? { loginExist: true } : null;
        })
      );
    };
  }

  controlsEgaux(control: AbstractControl): ValidationErrors | null {
    return control.get('password')?.value ==
      control.get('confirmPassword')?.value
      ? null
      : { pasEgaux: true };
  }

  submit() {
    let client = {
      prenom: this.form.get('prenom')?.value,
      nom: this.form.get('nom')?.value,
      adresse: {
        numero: this.form.get('numero')?.value,
        rue: this.form.get('rue')?.value,
        codePostal: this.form.get('codePostal')?.value,
        ville: this.form.get('ville')?.value,
      },
      compte: {
        login: this.form.get('login')?.value,
        password: this.form.get('passwordGrp.password')?.value,
      },
    };
    this.clientSrv.inscription(client).subscribe((client) => {
      console.debug(client);
      this.router.navigateByUrl('/login');
    });
  }
}
