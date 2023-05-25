import { Component } from '@angular/core';

@Component({
  selector: 'app-demo-directive',
  templateUrl: './demo-directive.component.html',
  styleUrls: ['./demo-directive.component.css'],
})
export class DemoDirectiveComponent {
  display() {
    return false;
  }
}
