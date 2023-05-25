import { Component } from '@angular/core';
import { Produit } from 'src/app/models/produit';

@Component({
  selector: 'app-demo-directive',
  templateUrl: './demo-directive.component.html',
  styleUrls: ['./demo-directive.component.css'],
})
export class DemoDirectiveComponent {
  //tabString:Array<string>=[]
  //tabString: string[] = ['aaa', 'bbb', 'ccc'];

  tabString = ['aaa', 'bbb', 'ccc'];
  tabProduit: Produit[] = [
    new Produit('tele', 1000),
    new Produit('telephone', 500),
    new Produit('ordinateur', 500),
  ];

  constructor() {
    this.tabProduit.push(new Produit('souris', 5));
  }

  display() {
    return false;
  }
}
