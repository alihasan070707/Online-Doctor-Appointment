import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MainComponent } from './main/main.component';
import { PatientRegisterComponent } from './patient-register/patient-register.component';

import { PatientLoginComponent } from './patient-login/patient-login.component';
import { pathToFileURL } from 'url';
import { DoctorRegisterationComponent } from './doctor-registeration/doctor-registeration.component';
import { DoctorLoginComponent } from './doctor-login/doctor-login.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';

const routes: Routes = [
  { path: '', component: MainComponent, pathMatch: 'full' },
  { path: 'patientLogin', component: PatientLoginComponent },
  { path: 'patientRegister', component: PatientRegisterComponent },
  { path: 'doctorRegister', component: DoctorRegisterationComponent },
  { path: 'doctorLogin', component: DoctorRegisterationComponent },
  { path: 'bookAppointment', component: BookAppointmentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
