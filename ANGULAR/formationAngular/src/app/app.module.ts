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
import { BackgroundDirective } from './directives/background.directive';
import { RouterModule, Routes } from '@angular/router';
import { ProduitDetailComponent } from './components/produit-detail/produit-detail.component';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

const routes: Routes = [
  { path: 'sondage', component: MatierePrefereeComponent },
  { path: 'produit', component: ProduitComponent },
  { path: 'produit/:id', component: ProduitDetailComponent },
  { path: 'personne', component: PersonneComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', component: NotFoundComponent },
];

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
    BackgroundDirective,
    NotFoundComponent,
    HomeComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
