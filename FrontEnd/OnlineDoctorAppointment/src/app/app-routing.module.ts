import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MainComponent } from './main/main.component';
import { PatientRegisterComponent } from './patient-register/patient-register.component';

import { PatientLoginComponent } from './patient-login/patient-login.component';
import { pathToFileURL } from 'url';
import { DoctorRegisterationComponent } from './doctor-registeration/doctor-registeration.component';
import { DoctorLoginComponent } from './doctor-login/doctor-login.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { PatientProfileComponent } from './patient-profile/patient-profile.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { SearchDoctorsComponent } from './search-doctors/search-doctors.component';
import { DoctorProfileComponent } from './doctor-profile/doctor-profile.component';
import { DocAppointmentComponent } from './doc-appointment/doc-appointment.component';
import { SetScheduleComponent } from './set-schedule/set-schedule.component';
import { FooterComponent } from './footer/footer.component';
import { AboutUsComponent } from './about-us/about-us.component';

const routes: Routes = [
  { path: '', component: MainComponent, pathMatch: 'full' },
  { path: 'patientLogin', component: PatientLoginComponent },
  { path: 'patientRegister', component: PatientRegisterComponent },
  { path: 'doctorRegister', component: DoctorRegisterationComponent },
  { path: 'doctorLogin', component: DoctorLoginComponent },
  { path: 'doctorLogin', component: DoctorRegisterationComponent },
  { path: 'bookAppointment', component: BookAppointmentComponent },
  { path: 'searchdoctor', component: SearchDoctorsComponent },
  { path: 'setSchedule', component: SetScheduleComponent},
  { path: 'footer', component: FooterComponent},
  { path:'aboutUs', component: AboutUsComponent},

  {
    path: 'patient-profile',
    component: PatientProfileComponent,
    children: [
      { path: 'appointments', component: AppointmentsComponent },
      { path: 'my-profile', component: MyProfileComponent },
      { path: 'previous-prescription', component: PrescriptionComponent },
      { path: '**', component: MyProfileComponent },
    ],
  },
  {
    path: 'doctor-profile',
    component: DoctorProfileComponent,
    children: [
      { path: 'doc-appointments', component: DocAppointmentComponent },
      { path: 'my-profile', component: MyProfileComponent },
      { path: 'previous-prescription', component: PrescriptionComponent },
      { path: '**', component: MyProfileComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
