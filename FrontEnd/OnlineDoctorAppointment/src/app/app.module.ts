import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { PatientLoginComponent } from './patient-login/patient-login.component';
import { DoctorRegisterationComponent } from './doctor-registeration/doctor-registeration.component';
import { FooterComponent } from './footer/footer.component';
import { MainComponent } from './main/main.component';
import { PatientRegisterComponent } from './patient-register/patient-register.component';

@NgModule({
  declarations: [
    AppComponent,
    DoctorRegisterationComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    PatientRegisterComponent,
    PatientLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
