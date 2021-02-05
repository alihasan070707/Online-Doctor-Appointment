import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Doctor } from '../doctorModel';

@Component({
  selector: 'app-doctor-registeration',
  templateUrl: './doctor-registeration.component.html',
  styleUrls: ['./doctor-registeration.component.css']
})
export class DoctorRegisterationComponent implements OnInit {
  result:string;
  doctor:Doctor;
  genders = ['Male', 'Female', 'Other'];
  photo:File=null;
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  onFileSelect(event) {
    this.photo = <File>event.target.files[0];
  }
  onSubmit(myForm:NgForm) {
    const doctor = myForm.value;
    //console.log(myForm.value);
    const {location, city, state, pincode} = myForm.value;
    doctor.address = {location, city, state, pincode}
    delete doctor.city;
    delete doctor.state;
    delete doctor.location;
    delete doctor.pincode;
    console.log(doctor);
    
    const formData = new FormData();
    formData.append('data', JSON.stringify(doctor));
    formData.append('file', this.photo, this.photo.name);
    this.http.post("http://localhost:8080/doctor/register", formData).subscribe(data => console.log(data));
  }
}
