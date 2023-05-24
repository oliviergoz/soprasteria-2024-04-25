import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './components/demo/demo.component';
import { BonjourComponent } from './components/bonjour/bonjour.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    BonjourComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
