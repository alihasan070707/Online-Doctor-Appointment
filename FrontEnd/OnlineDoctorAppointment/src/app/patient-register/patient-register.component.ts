import { Component, NgModule, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PatientRegisterService } from '../patient-register.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-patient-register',
  templateUrl: './patient-register.component.html',
  styleUrls: ['./patient-register.component.css'],
})
export class PatientRegisterComponent implements OnInit {
  genders = ['Male', 'Female', 'Other'];
  photo: File = null;
  patientObj: any;
  
  constructor(
    private _registerService: PatientRegisterService,
    private http: HttpClient,
    private router: Router,
    private spinner:NgxSpinnerService
  ) {}

  ngOnInit(): void {}

  // onSubmit(form: NgForm){
  //   console.log(form.value);
  //   this.patientObj = form.value;
  //   console.log(this.patientObj);

  //   this._registerService.register(this.patientObj)
  //     .subscribe(
  //       data => console.log('Success!', data),
  //       error => console.error ('Error!', error)
  //     )
  // }

  onFileSelect(event) {
    this.photo = <File>event.target.files[0];
  }
  onSubmit(myForm: NgForm) {
    this.spinner.show();
    console.log(myForm.value);

    const formData = new FormData();
    formData.append('data', JSON.stringify(myForm.value));
    formData.append('photo', this.photo, this.photo.name);
    this.http
      .post('http://localhost:8080/patient/register', formData)
      .subscribe((data) =>{ console.log(data) ; this.router.navigate(['patientLogin']);this.spinner.hide()});
  }
}
