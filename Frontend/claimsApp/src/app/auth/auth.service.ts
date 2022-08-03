import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, Subject, throwError } from 'rxjs';
import { User } from './user.model';


@Injectable({ providedIn: 'root' })
export class AuthService {
  user = new BehaviorSubject<User | null>(null);
  userId: string='';
  timeout = new Subject<boolean>();
  private tokenExirationTimer: any;
   token : String ='';
   validatedUser:boolean=false

  constructor(private http: HttpClient, private router: Router) {}

  logins(inputFields: { userName: string; password: string }) :Observable<Object>{

    console.log(JSON.stringify(inputFields))
    return this.http
      .post( 'http://localhost:8400/auth/authenticate', inputFields);

  }

  logout() {
    this.token='';
    this.validatedUser=false;
    this.user.next(null);
    this.router.navigate(['./auth']);
    this.removeUser();

    if (this.tokenExirationTimer) {
      clearTimeout(this.tokenExirationTimer);
    }
    this.tokenExirationTimer = null;
  }

  private removeUser() {
    localStorage.removeItem('userData');
  }
}
