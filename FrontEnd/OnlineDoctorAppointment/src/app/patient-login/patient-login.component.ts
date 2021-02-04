import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'patient-login',
  templateUrl: './patient-login.component.html',
  styleUrls: ['./patient-login.component.css'],
})
export class PatientLoginComponent implements OnInit {
  email: string;
  password: string;
  message:string;
  constructor(private router: Router,private http:HttpClient) {}

  ngOnInit(): void {}
  submitHandler(data) {
    const formData = new FormData();
    formData.append('email', this.email);
    formData.append('password', this.password);
    console.log(this.email);
    console.log(this.password);
    this.http
      .post('http://localhost:8080/patient/login', formData)
      .subscribe((data) => {
        if (data != null) this.createSession(data);
        else {
          this.message = '*Please check your userid and password';
        }
      });
  }
  createSession(data) {
    localStorage.setItem('isLoggedIn', 'true');
    localStorage.setItem('patientToken', data);
    this.router.navigate(['patient-profile']);
  }

  redirectToRegister() {
    this.router.navigate(['patientRegister']);
  }
}
