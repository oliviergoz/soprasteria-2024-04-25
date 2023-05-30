import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FournisseurListComponent } from './components/fournisseur/fournisseur-list/fournisseur-list.component';
import { FournisseurEditComponent } from './components/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { HomeComponent } from './components/home/home.component';
import { ProduitListComponent } from './components/produit/produit-list/produit-list.component';
import { ProduitEditComponent } from './components/produit/produit-edit/produit-edit.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: 'fournisseur', component: FournisseurListComponent },
  { path: 'fournisseur/edit', component: FournisseurEditComponent },
  { path: 'fournisseur/edit/:id', component: FournisseurEditComponent },
  { path: 'produit', component: ProduitListComponent },
  { path: 'produit/edit', component: ProduitEditComponent },
  { path: 'produit/edit/:id', component: ProduitEditComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
