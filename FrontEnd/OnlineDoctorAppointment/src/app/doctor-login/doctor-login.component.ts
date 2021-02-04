import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
@Component({
  selector: 'app-doctor-login',
  templateUrl: './doctor-login.component.html',
  styleUrls: ['./doctor-login.component.css'],
})
export class DoctorLoginComponent implements OnInit {
  email: string;
  password: string;
  message: string;
  constructor(private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    console.log(localStorage.getItem('doctorToken'));
    
    if(localStorage.getItem('doctorToken')!=null)
    this.router.navigate(['doctor-profile']);
  }
  submitHandler(data) {
    const formData = new FormData();
    formData.append('email', this.email);
    formData.append('password', this.password);
    console.log(this.email);
    console.log(this.password);
    this.http
      .post('http://localhost:8080/doctor/login', formData)
      .subscribe((data) => {
        if (data != null) this.createSession(data);
        else {
          this.message = '*Please check your userid and password';
        }
      });
  }
  createSession(data) {
    localStorage.setItem('isLoggedIn', 'true');
    localStorage.setItem('doctorToken', data);
    this.router.navigate(['doctor-profile']);
  }

  redirectToRegisterDoc() {
    this.router.navigate(['doctorRegister']);
  }
}
