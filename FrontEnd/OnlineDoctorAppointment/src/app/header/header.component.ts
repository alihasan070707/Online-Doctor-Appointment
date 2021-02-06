import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  patientId;
  doctorId;
  isLoggedin: boolean;
  constructor(private router: Router) {}

  ngOnInit(): void {
    this.patientId = localStorage.getItem('patientToken');
    this.doctorId = localStorage.getItem('doctorToken');
  }
  signInButton() {
    this.router.navigate(['patientLogin']);
  }
  logoutButton() {
    localStorage.removeItem('patientToken');
    localStorage.removeItem('doctorToken');
    this.router.navigate(['/']);
  }

  setIsLoggedIn(value) {
    this.isLoggedin = value;
  }
}
