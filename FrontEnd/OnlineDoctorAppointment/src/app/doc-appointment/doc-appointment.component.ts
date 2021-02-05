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
  id;

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.id = localStorage.getItem('doctorToken');
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
    this.router.navigate([
      'doctor-profile/previous-prescription',
      { patientId: patientId },
    ]);
  }
  uploadPrescription(patientId, event) {
    let pdf = event.target.files[0];
    console.log(patientId);
    const formdata = new FormData();
    formdata.append('patientId', patientId);
    formdata.append('pdfFile', pdf);
    this.http
      .post('http://localhost:8080/doctor/upload', formdata)
      .subscribe((data) => console.log(data));
  }
}
