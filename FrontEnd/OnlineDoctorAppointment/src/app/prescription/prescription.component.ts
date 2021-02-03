import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

import * as fileSaver from 'file-saver';

@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css'],
})
export class PrescriptionComponent implements OnInit {
  prescriptions: any = [];
  patientId = 1;
  file: any;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http
      .get(
        'http://localhost:8080/patient/prescriptions/?patientId=' +
          this.patientId
      )
      .subscribe((data) => (this.prescriptions = data));
  }

  downloadFile(prescription): any {
    this.http
      .get('http://localhost:8080/patient/download/?files=' + prescription, {
        responseType: 'blob',
      })
      .subscribe((data) => fileSaver.saveAs(data, 'Prescription.pdf'));
  }
}
