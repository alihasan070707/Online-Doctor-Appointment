import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

doctors:any = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.pageLoad();
  }

  acceptDoctor(doctorId) {
    this.http.get("http://localhost:8080/admin/acceptDoctor/?doctorId="+doctorId).subscribe(data => console.log(data));
    this.pageLoad();
  }

  rejectDoctor(doctorId) {
    this.http.get("http://localhost:8080/admin/rejectDoctor/?doctorId="+doctorId).subscribe(data => console.log(data));
    this.pageLoad();
  }

  pageLoad() {
    this.http.get("http://localhost:8080/admin/doctorList").subscribe(data => this.doctors = data);
  }
}
