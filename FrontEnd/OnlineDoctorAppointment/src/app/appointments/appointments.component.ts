import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css'],
})
export class AppointmentsComponent implements OnInit {
  appointments: any = [];
  patientId;

  constructor(private http: HttpClient,
    private spinner:NgxSpinnerService) {}

  ngOnInit(): void {
    this.patientId = localStorage.getItem('patientToken');
    this.pageLoad();
  }

  cancelAppointment(appId) {
    this.spinner.show();
    this.http
      .get(
        'http://localhost:8080/patient/cancelAppointment/?appId=' +
          appId
      )
      .subscribe((data) => {
        console.log(data); 
        this.pageLoad();
        this.spinner.hide();
       });
   
  }
  pageLoad() {
    this.http
      .get(
        'http://localhost:8080/patient/appointments/?patientId=' +
          this.patientId
      )
      .subscribe((data) => {
        this.appointments = data;
        console.log(data);
      });
  }
}
