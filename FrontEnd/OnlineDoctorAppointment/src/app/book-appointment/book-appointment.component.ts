import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css'],
})
export class BookAppointmentComponent implements OnInit {
  timeFrames: any = [];
  selectedTime: string;
  canBook: boolean = false;
  doctor;
  patient;
  timeFrame: number;
  status = '5';
  // var elem = JSON.parse(this.routeParams.get("elem"));

  constructor(private http: HttpClient, private routeParams: ActivatedRoute) {}

  ngOnInit(): void {
    this.doctor = JSON.parse(
      this.routeParams.snapshot.paramMap.get('doctorId')
    );
    console.log(this.doctor);
    this.patient = localStorage.getItem('patientToken');
  }
  datePicked(event) {
    console.log(event.target.value);
    this.timeFrames = [];
    console.log(this.timeFrames);
    const formData = new FormData();
    formData.append('drId', this.doctor);
    formData.append('date', event.target.value);
    this.http
      .post('http://localhost:8080/patient/time', formData)
      .subscribe((data) => (this.timeFrames = data));
  }
  OnTimeSelect(event) {
    this.selectedTime = event.target.value;
    console.log(event.target.attributes.value.nodeValue);
    console.log(event.target.attributes.name.nodeValue);
    this.canBook = true;
    this.timeFrame = event.target.attributes.name.nodeValue;
  }
  OnBookAppointment() {
    const formData = new FormData();
    formData.append('drId', this.doctor);
    formData.append('patientId', this.patient);
    formData.append('timeFrame', this.timeFrame.toString());
    formData.append('status', this.status);
    this.http
      .post('http://localhost:8080/patient/appointment', formData)
      .subscribe((data) => (this.timeFrames = data));
  }
}
