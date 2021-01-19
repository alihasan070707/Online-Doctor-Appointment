import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctor-login',
  templateUrl: './doctor-login.component.html',
  styleUrls: ['./doctor-login.component.css'],
})
export class DoctorLoginComponent implements OnInit {
  email: string;
  password: string;
  constructor(private router: Router) {}

  ngOnInit(): void {}
  submitHandler(data) {
    console.log(this.email);
    console.log(this.password);
  }

  redirectToRegisterDoc() {
    this.router.navigate(['doctorRegister']);
  }
}
