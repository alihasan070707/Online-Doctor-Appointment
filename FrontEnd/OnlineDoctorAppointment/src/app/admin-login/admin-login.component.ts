import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  email: string;
  password: string;
  message: string;

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    if(localStorage.getItem('adminToken')!=null)
    this.router.navigate(['adminPage']);
  }

  submitHandler() {
    const formData = new FormData();
    formData.append('email', this.email);
    formData.append('password', this.password);
    console.log(this.email);
    console.log(this.password);
    this.http
      .post('http://localhost:8080/admin/login', formData)
      .subscribe((data) => {
        if (data != null) this.createSession(data);
        else {
          this.message = '*Please check your userid and password';
        }
      });
  }
  createSession(data) {
    localStorage.setItem('isLoggedIn', 'true');
    localStorage.setItem('adminToken', data);
    this.router.navigate(['adminPage']);
  }
}
