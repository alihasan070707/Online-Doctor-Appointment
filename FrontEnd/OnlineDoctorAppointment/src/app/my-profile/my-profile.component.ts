import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {
  patient:any;
  patientId=1;
  constructor(private http : HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/patient/getDetailis/?id="+this.patientId).subscribe(data => this.patient = data);
    console.log(this.patient);
    
  }

}
