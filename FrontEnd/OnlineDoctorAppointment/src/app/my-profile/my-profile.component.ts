import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {
  patient:any;
  patientId;
  doctor:any;
  doctorId;
  constructor(private http : HttpClient, private router: Router) { }

  ngOnInit(): void {
    if(localStorage.getItem('doctorToken')!=null){
      this.doctorId = localStorage.getItem('doctorToken');
      this.http.get("http://localhost:8080/doctor/getDetails/?id="+this.doctorId).subscribe(data => this.doctor = data);
    }
    else if(localStorage.getItem('patientToken')!=null) {
      this.patientId = localStorage.getItem('patientToken'); 
      this.http.get("http://localhost:8080/patient/getDetails/?id="+this.patientId).subscribe(data => this.patient = data);
    }
    else {
      this.router.navigate(['/']);
    }
  }

}
