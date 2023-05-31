import { Injectable } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import {
  ActivatedRouteSnapshot,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class LoggedGuardService {
  constructor(private authSrv: AuthenticationService, private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean | UrlTree {
    if (this.authSrv.isLogged()) {
      return true;
    } else {
      return this.router.createUrlTree(['/login']);
    }
  }
}
