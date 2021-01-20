import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css'],
})
export class BookAppointmentComponent implements OnInit {
  timeFrames: any = [];
  selectedTime: string;
  canBook: boolean = false;
  doctor = '1';
  patient = '1';
  timeFrame: number;
  status = '5';
  constructor(private http: HttpClient) {}

  ngOnInit(): void {}
  datePicked(event) {
    console.log(event.target.value);
    this.timeFrames = [];
    console.log(this.timeFrames);
    const formData = new FormData();
    formData.append('drId', '1');
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
