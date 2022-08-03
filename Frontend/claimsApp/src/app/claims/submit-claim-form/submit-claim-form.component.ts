import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CanComponentLeave } from '../guards/claims.candeactivate-guard';
import { ClaimsService } from '../claims.service';

@Component({
  selector: 'app-submit-claim-form',
  templateUrl: './submit-claim-form.component.html',
  styleUrls: ['./submit-claim-form.component.css'],
})
export class SubmitClaimFormComponent implements CanComponentLeave {
  isValidating: boolean = false;
  error: string | null = null;
  @ViewChild('f') form: NgForm | null = null;

  constructor(
    private claimsService: ClaimsService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  canLeave() {
    if (this.form?.dirty) {
      return window.confirm('You have unsaved changes. Do you want to leave?');
    }
    return true;
  }

  submitClaim(
    policyId: number,
    policyName: String,
    policyBenefits: String,
    hospitalName: String,
    benefitsAvailed: number,
    amount: number
  ) {
    this.isValidating = true;
    this.claimsService.submitClaim({
        policyId,
        policyName,
        policyBenefits,
        hospitalName,
        benefitsAvailed,
        amount,
      })
      .subscribe(
        (response) => {
          console.log("Submitted Claim");
          this.error = null;
          this.isValidating = true;
          this.router.navigate(['./home'], { relativeTo: this.route });
        },
        (errorMessage) => {
          console.log("Error in Submitting Claim")
          this.isValidating = false;
          this.error = 'Invalid Details. Please check your details again';
          console.log(errorMessage);
        }
      );
  }

  onSubmit(form: NgForm) {
    console.log("Inside on Submit Method(Submit Claim)");
    this.submitClaim(
      form.value.policyId,
      form.value.policyName,
      form.value.policyBenefits,
      form.value.hospitalName,
      form.value.benefitsAvailed,
      form.value.amount
    );

    form.reset();
  }

  handleError() {
    this.error = null;
  }
}
