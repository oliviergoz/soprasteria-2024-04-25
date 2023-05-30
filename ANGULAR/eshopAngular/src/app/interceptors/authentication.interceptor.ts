import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {
  constructor() {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    if (sessionStorage.getItem('token')) {
      request = request.clone({
        headers: request.headers.append(
          'Authorization',
          sessionStorage.getItem('token')!
        ),
      });
    }
    //la requete reprend sa route
    return next.handle(request);
  }
}
