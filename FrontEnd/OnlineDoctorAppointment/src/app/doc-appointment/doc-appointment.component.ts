import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doc-appointment',
  templateUrl: './doc-appointment.component.html',
  styleUrls: ['./doc-appointment.component.css'],
})
export class DocAppointmentComponent implements OnInit {
  appointments: any = [];
  id = 1;
  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.pageLoad();
    console.log(localStorage.getItem('doctorToken'));
  }
  cancelAppointment(appId) {
    this.http
      .get('http://localhost:8080/doctor/cancelAppointment/?appId=' + appId)
      .subscribe((data) => console.log(data));
    this.pageLoad();
  }
  pageLoad() {
    this.http
      .get('http://localhost:8080/doctor/appointments/?doctorId=' + this.id)
      .subscribe((data) => {
        console.log(data);
        this.appointments = data;
      });
  }

  patientPrescriptions(patientId) {
    this.router.navigate(['previous-prescription',{patientId: patientId}]);
  }
}
