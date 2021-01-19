import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from  '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class PatientRegisterService {

  temp:any;
  
  _url = 'http://localhost:8080/patient/register';
  constructor(private _http: HttpClient) { }

  register(patient: any) {
    this.temp={
      data:patient
    }
    let body = new HttpParams();
    body = body.set("data", patient);
    return this._http.post<any>(this._url, body);
  }
}
