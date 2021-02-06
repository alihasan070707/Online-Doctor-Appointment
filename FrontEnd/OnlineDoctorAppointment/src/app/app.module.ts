import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { PatientLoginComponent } from './patient-login/patient-login.component';
import { DoctorRegisterationComponent } from './doctor-registeration/doctor-registeration.component';
import { FooterComponent } from './footer/footer.component';
import { MainComponent } from './main/main.component';
import { PatientRegisterComponent } from './patient-register/patient-register.component';
import { DoctorLoginComponent } from './doctor-login/doctor-login.component';
import { SearchDoctorsComponent } from './search-doctors/search-doctors.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { PatientProfileComponent } from './patient-profile/patient-profile.component';
import { DoctorProfileComponent } from './doctor-profile/doctor-profile.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { DocAppointmentComponent } from './doc-appointment/doc-appointment.component';
import { SetScheduleComponent } from './set-schedule/set-schedule.component';
import { AuthGuard } from './auth.guard';
import { AboutUsComponent } from './about-us/about-us.component';

@NgModule({
  declarations: [
    AppComponent,
    DoctorRegisterationComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    PatientRegisterComponent,
    PatientLoginComponent,
    DoctorLoginComponent,
    SearchDoctorsComponent,
    BookAppointmentComponent,
    PatientProfileComponent,
    DoctorProfileComponent,
    AppointmentsComponent,
    MyProfileComponent,
    PrescriptionComponent,
    DocAppointmentComponent,
    SetScheduleComponent,
    AboutUsComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule,NgSelectModule],
  providers: [AuthGuard],
  bootstrap: [AppComponent],
})
export class AppModule {}
