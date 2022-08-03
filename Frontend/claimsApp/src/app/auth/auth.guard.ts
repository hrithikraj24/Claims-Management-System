import { Injectable } from '@angular/core';
import { CanActivate, Router, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate():
    | boolean
    | Promise<boolean | UrlTree>
    | Observable<boolean | UrlTree> {
    if (this.authService.validatedUser==true) return true;

    else
      return this.router.navigate(["auth"]);
  }
}
