import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './components/demo/demo.component';
import { BonjourComponent } from './components/bonjour/bonjour.component';
import { ProduitComponent } from './components/produit/produit.component';
import { PersonneComponent } from './components/personne/personne.component';
import { FormsModule } from '@angular/forms';
import { FormPersonneComponent } from './components/form-personne/form-personne.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    BonjourComponent,
    ProduitComponent,
    PersonneComponent,
    FormPersonneComponent,
  ],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
