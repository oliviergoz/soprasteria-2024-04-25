import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FournisseurListComponent } from './components/fournisseur/fournisseur-list/fournisseur-list.component';
import { FournisseurEditComponent } from './components/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { HomeComponent } from './components/home/home.component';
import { ProduitListComponent } from './components/produit/produit-list/produit-list.component';
import { ProduitEditComponent } from './components/produit/produit-edit/produit-edit.component';
import { LoginComponent } from './components/login/login.component';
import { AdminGuardService } from './services/guard/admin-guard.service';
import { LoggedGuardService } from './services/guard/logged-guard.service';
import { LoggoffGuardService } from './services/guard/loggoff-guard.service';
import { ProduitDispoComponent } from './components/commande/produit-dispo/produit-dispo.component';
import { ClientGuardService } from './services/guard/client-guard.service';

const routes: Routes = [
  {
    path: 'fournisseur',
    component: FournisseurListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'fournisseur/edit',
    component: FournisseurEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'fournisseur/edit/:id',
    component: FournisseurEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'produit',
    component: ProduitListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'produit/edit',
    component: ProduitEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'produit/edit/:id',
    component: ProduitEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'commander',
    component: ProduitDispoComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [LoggoffGuardService],
  },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
