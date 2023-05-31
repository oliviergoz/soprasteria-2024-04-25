import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private static URL: string = 'http://localhost:8080/eshop/api/client';
  constructor(private httpClient: HttpClient) {}

  public inscription(client: any): Observable<any> {
    return this.httpClient.post(`${ClientService.URL}/inscription`, client);
  }

  public loginExist(login: string): Observable<boolean> {
    return this.httpClient.get<boolean>(`${ClientService.URL}/login/${login}`);
  }
}
