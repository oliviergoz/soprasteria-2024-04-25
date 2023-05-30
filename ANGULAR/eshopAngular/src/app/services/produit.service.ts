import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../model/produit';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  private static URL: string = 'http://localhost:8080/eshop/api/produit';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(ProduitService.URL);
  }

  public getById(id: number): Observable<Produit> {
    return this.httpClient.get<Produit>(`${ProduitService.URL}/${id}`);
  }

  public create(produit: Produit): Observable<Produit> {
    return this.httpClient.post<Produit>(ProduitService.URL, produit);
  }

  public update(produit: Produit): Observable<Produit> {
    return this.httpClient.put<Produit>(
      `${ProduitService.URL}/${produit.id}`,
      produit
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ProduitService.URL}/${id}`);
  }
}
