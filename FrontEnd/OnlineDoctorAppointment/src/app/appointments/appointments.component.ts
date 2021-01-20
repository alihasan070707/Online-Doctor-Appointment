import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {

  appointments:any = [];
  id = 1;

  constructor(private http : HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/patient/appointments/?id"+this.id).subscribe(data => this.appointments = data);
  }

}
