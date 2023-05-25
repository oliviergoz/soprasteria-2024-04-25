import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './components/demo/demo.component';
import { BonjourComponent } from './components/bonjour/bonjour.component';
import { ProduitComponent } from './components/produit/produit.component';
import { PersonneComponent } from './components/personne/personne.component';
import { FormsModule } from '@angular/forms';
import { FormPersonneComponent } from './components/form-personne/form-personne.component';
import { FormProduitComponent } from './components/form-produit/form-produit.component';
import { DisplayProduitComponent } from './components/display-produit/display-produit.component';
import { MatiereComponent } from './components/sondage/matiere/matiere.component';
import { MatierePrefereeComponent } from './components/sondage/matiere-preferee/matiere-preferee.component';
import { DemoDirectiveComponent } from './components/demo-directive/demo-directive.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    BonjourComponent,
    ProduitComponent,
    PersonneComponent,
    FormPersonneComponent,
    FormProduitComponent,
    DisplayProduitComponent,
    MatiereComponent,
    MatierePrefereeComponent,
    DemoDirectiveComponent,
  ],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
