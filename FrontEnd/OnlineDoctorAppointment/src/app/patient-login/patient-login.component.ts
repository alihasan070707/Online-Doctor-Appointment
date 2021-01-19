import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'patient-login',
  templateUrl: './patient-login.component.html',
  styleUrls: ['./patient-login.component.css']
})
export class PatientLoginComponent implements OnInit {
  email : string;
  password: string;
  constructor() { }

  ngOnInit(): void {
  }
  submitHandler(data){
    console.log(this.email);
    console.log(this.password);
  }
}
