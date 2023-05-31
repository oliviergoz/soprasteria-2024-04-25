import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent {
  constructor(private router: Router, private authSrv: AuthenticationService) {}
  get login() {
    if (sessionStorage.getItem('compte')) {
      return JSON.parse(sessionStorage.getItem('compte')!).login;
    }
  }

  get admin() {
    return this.authSrv.isAdmin();
  }

  get client() {
    return this.authSrv.isClient();
  }

  logoff() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }
}
