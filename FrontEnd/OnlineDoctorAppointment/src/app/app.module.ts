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
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule,NgSelectModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
