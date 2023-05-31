import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FournisseurListComponent } from './components/fournisseur/fournisseur-list/fournisseur-list.component';
import { FournisseurEditComponent } from './components/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { MenuComponent } from './components/menu/menu.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProduitListComponent } from './components/produit/produit-list/produit-list.component';
import { ProduitEditComponent } from './components/produit/produit-edit/produit-edit.component';
import { LoginComponent } from './components/login/login.component';
import { AuthenticationInterceptor } from './interceptors/authentication.interceptor';
import { ProduitDispoComponent } from './components/commande/produit-dispo/produit-dispo.component';
import { InscriptionComponent } from './components/inscription/inscription.component';

@NgModule({
  declarations: [
    AppComponent,
    FournisseurListComponent,
    FournisseurEditComponent,
    MenuComponent,
    HomeComponent,
    ProduitListComponent,
    ProduitEditComponent,
    LoginComponent,
    ProduitDispoComponent,
    InscriptionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
