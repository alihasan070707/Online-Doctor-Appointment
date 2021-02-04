import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-doc-appointment',
  templateUrl: './doc-appointment.component.html',
  styleUrls: ['./doc-appointment.component.css'],
})
export class DocAppointmentComponent implements OnInit {
  appointments: any = [];
  id = 1;
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http
      .get('http://localhost:8080/doctor/appointments/?doctorId=' + this.id)
      .subscribe((data) => {
        console.log(data);
        this.appointments = data;
      });
    console.log(localStorage.getItem('doctorToken'));
  }
}
