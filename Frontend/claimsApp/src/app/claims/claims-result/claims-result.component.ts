import { Component, OnInit } from '@angular/core';
import { Bills } from '../Bills';
import { Claims } from '../Claims';
import { ClaimsService } from '../claims.service';

@Component({
  selector: 'app-claims-result',
  templateUrl: './claims-result.component.html',
  styleUrls: ['./claims-result.component.css'],
})
export class ClaimsResultComponent implements OnInit {
  isClaimStatusMode: boolean = false;
  claim : Claims = new Claims();
  bill : Bills = new Bills();

  constructor(private claimsService: ClaimsService) {}

  ngOnInit() {
    console.log(this.claimsService.billResponse)
    console.log(this.claimsService.claimStatusResponse)
    if (this.claimsService.billResponse) {
      this.bill = this.claimsService.bill;
      this.isClaimStatusMode = false;
      console.log("Bill Portal")
    } else if (this.claimsService.claimStatusResponse) {
      this.claim = this.claimsService.claim;
      this.isClaimStatusMode = true;
      console.log("Claim Portal")
    }
  }
}
