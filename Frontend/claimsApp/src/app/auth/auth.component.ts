import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent implements OnInit, OnDestroy {
  isValidating: boolean = false;
  isLoading: boolean = false;
  error: null | string = null;
  userSubscription: Subscription = new Subscription();
  authResponse: any;
  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit() {
    this.userSubscription = this.authService.user.subscribe((user) => {
      if (user) {
        this.router.navigate(['./home']);
      }
    });
  }

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
  }

  login(userName: string, password: string) {
    this.isValidating = true;

    this.authService.logins({ userName, password }).subscribe(
      (response) => {
        this.authResponse = response
        console.log(JSON.stringify(this.authResponse))
        this.authService.token = this.authResponse.token;
        this.authService.validatedUser=true
        this.isValidating = true;
        this.authService.userId=userName;
        this.error = null;
        this.router.navigate(['./home']);
      },
      (errorMessage) => {
        this.isValidating = false;
        this.error = 'Invalid Username or Password';
        console.log(errorMessage);
      }
    );
  }

  onSubmit(form: NgForm) {
    const username = form.value.username;
    const password = form.value.password;

    this.login(username, password);

    form.reset();
  }

  handleError() {
    this.error = null;
  }
}
