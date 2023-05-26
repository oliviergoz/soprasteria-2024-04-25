import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { FormBonjourComponent } from './components/form-bonjour/form-bonjour.component';
import { BonjourComponent } from './components/bonjour/bonjour.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'bonjour', component: FormBonjourComponent },
  { path: 'bonjour/:nom', component: BonjourComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
