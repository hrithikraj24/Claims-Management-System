import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { ClaimsService } from '../claims.service';

@Component({
  selector: 'app-claims-form',
  templateUrl: './claims-form.component.html',
  styleUrls: ['./claims-form.component.css'],
})
export class ClaimsFormComponent implements OnInit {
  isValidating: boolean = false;
  isLoading: boolean = false;
  isClaimStatusMode: boolean = false;
  isBillMode: boolean = false;
  error: null | string = null;
  userId: string='';

  constructor(
    private claimsService: ClaimsService,
    private router: Router,
    private route: ActivatedRoute,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.userId=this.authService.userId;
    console.log(this.userId);
    this.route.data.subscribe((data) => {
      if (data) {
        if (data['mode'] === 'claimStatusMode') {
          this.isClaimStatusMode = true;
          this.isBillMode = false;
        } else if (data['mode'] === 'billMode') {
          this.isBillMode = true;
          this.isClaimStatusMode = false;
        }
      }
    });
  }

  fetchBillStatus(MID: String) {
    this.isValidating = true;
    this.claimsService.getBill( MID ).subscribe(
      (response) => {
        this.isValidating = false;
        this.claimsService.bill = response;
        console.log(JSON.stringify( this.claimsService.bill));
        console.log(this.claimsService.bill.dueDate);
        this.router.navigate(['./result'], { relativeTo: this.route });
      },
      (errorMessage) => {
        this.isValidating = false;
        this.error = 'Invalid Details Provided. Please check your details again';
        console.log(errorMessage);
      }
    );
  }

  fetchClaimStatus(CID: number) {
    this.isValidating = true;
    this.claimsService.getClaim(CID).subscribe(
      (response) => {
        this.isValidating = false;
        this.claimsService.claim=response;
        console.log(JSON.stringify( this.claimsService.claim));
        console.log(this.claimsService.claim.amount);

        this.router.navigate(['./result'], { relativeTo: this.route });
      },
      (errorMessage) => {
        this.isValidating = false;
        this.error =
          'Invalid Details Provided. Please check your details again';
        console.log(errorMessage);
      }
    );
  }


  onSubmit(form: NgForm) {

    console.log("Inside on Submit method");
    if(this.isClaimStatusMode==true)
      this.fetchClaimStatus(form.value.claimID);
    else
      this.fetchBillStatus(form.value.memberID);
    form.reset();
  }

  handleError() {
    this.error = null;
  }
}
