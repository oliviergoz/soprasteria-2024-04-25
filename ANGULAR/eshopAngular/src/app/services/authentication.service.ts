import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private static URL: string = 'http://localhost:8080/eshop/api/auth';
  constructor(private httpClient: HttpClient) {}

  public login(login: string, password: string): Observable<any> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });
    return this.httpClient.get(AuthenticationService.URL, { headers: headers });
  }

  public isAdmin(): boolean {
    return this.checkRole('ROLE_ADMIN');
  }

  private checkRole(role: string): boolean {
    if (!this.isLogged()) {
      return false;
    }
    let compte: Compte = JSON.parse(
      sessionStorage.getItem('compte')!
    ) as Compte;
    return compte.role === role;
  }

  public isClient(): boolean {
    return this.checkRole('ROLE_CLIENT');
  }

  public isLogged(): boolean {
    return sessionStorage.getItem('token') != null;
  }
}
