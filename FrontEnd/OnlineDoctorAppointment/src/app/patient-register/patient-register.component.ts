import { Component, NgModule, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PatientRegisterService } from '../patient-register.service';

@Component({
  selector: 'app-patient-register',
  templateUrl: './patient-register.component.html',
  styleUrls: ['./patient-register.component.css']
})
export class PatientRegisterComponent implements OnInit {

  genders = ['Male', 'Female', 'Other'];

  patientObj:any;
  constructor(private _registerService: PatientRegisterService) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm){
    console.log(form.value);
    this.patientObj = form.value;
    console.log(this.patientObj);

    this._registerService.register(this.patientObj)
      .subscribe(
        data => console.log('Success!', data),
        error => console.error ('Error!', error)
      )
  }
}

